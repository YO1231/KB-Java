package org.scoula.module2.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//문제 8-1.
// VO 객체로 사용할 Country를 완성하세요.
// Lombok 어노테이션 설정
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private String code;
    private String countryName;
    private String Continent;
    private String SurfaceArea;

    private int id;
    private String cityName;
    private String countryCode;
    private String district;
    private int population;
}
