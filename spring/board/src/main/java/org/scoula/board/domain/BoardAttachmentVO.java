package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardAttachmentVO {
    private Long no;            //
    private Long bno;           // FK: Board의 no
    private String filename;    // 원본 파일명
    private String contentType; // 파일 mime-type
    private Long size;          // 파일의 크기
    private byte[] data;        // 파일 바이너리 데이터
    private Date regDate;       // 등록일

    // 팩토리 메서드
    public static BoardAttachmentVO of(MultipartFile part, Long bno) throws IOException {

        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .contentType(part.getContentType())
                .size(part.getSize())
                .data(part.getBytes())
                .build();
    }

    public String getFileSize() {
        return UploadFiles.getFormatSize(size);
    }

}

