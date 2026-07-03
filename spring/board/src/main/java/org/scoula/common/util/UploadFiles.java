package org.scoula.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class UploadFiles {

    public static String getFormatSize(Long size) {
        if (size <= 0)
            return "0";
        final String[] units = new String[] { "Bytes", "KB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }


    public static void download(HttpServletResponse response, byte[] data, String orgName, String contentType) throws Exception {
        response.setContentType(contentType != null ? contentType : "application/octet-stream");
        response.setContentLength(data.length);

        String filename = URLEncoder.encode(orgName, "UTF-8");	// 한글 파일명인 경우 인코딩 필수
        response.setHeader("Content-disposition", "attachment;filename=\"" + filename + "\"");

        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)) {
            bos.write(data);
        }
    }

}
