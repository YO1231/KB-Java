package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@WebFilter("/*")
public class PerformanceMonitorFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        // 요청 접수 시간
        LocalDateTime now = LocalDateTime.now();
        String requestTime =
                now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        long start = System.currentTimeMillis();

        // 다음 Filter 또는 Servlet 실행
        filterChain.doFilter(servletRequest, servletResponse);

        long end = System.currentTimeMillis();

        // 처리 수행 시간
        long elapsedTime = end - start;

        System.out.println("[" + requestTime + "] "
                + req.getRequestURI()
                + " - "
                + elapsedTime
                + "ms 소요");
    }
}
