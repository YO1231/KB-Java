package org.scoula.module2.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//문제 5-1.
// VO 객체로 사용할 City를 완성하세요.
// Lombok 어노테이션 설정
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
}
