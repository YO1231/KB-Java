package org.scoula.module2.dao;

import org.scoula.module2.domain.City;
import org.scoula.module2.domain.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    Connection conn;

    public CityDao(Connection conn) {
        this.conn = conn;
    }

    //city테이블에 데이터를 삽입 처리 기능 구현
    //문제 5-2. insert()메서드를 완성하여 데이터 삽입 처리를 구현하시오.
    //     조건1) try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //     조건2) db처리와 관련된 모든 객체(conn 제외)에 대해 "자원해제 처리"를 하시오.
    //     조건3) city테이블에 넣을 데이터는 "sql문에 직접 필드 타입에 맞게 넣어" SQL문을 완성하시오.
    //     조건4) 해당 메서드에서 데이터 삽입 처리후 결과는 반환하지 않는다.
    public void insert(City city) {
        //SQL문 완성
        String sql = "insert into city(id ,name, countryCode, district, population) values(?,?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, city.getId());
            pstmt.setString(2, city.getName());
            pstmt.setString(3, city.getCountryCode());
            pstmt.setString(4, city.getDistrict());
            pstmt.setInt(5, city.getPopulation());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    } //insert기능 구현

    //city테이블에서 검색하여 UI에 반환 처리 기능 구현
    //문제 6-1. selectList()메서드를 완성하여 데이터 검색 처리를 구현하시오.
    //   조건1)  try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //   조건2)  db처리와 관련된 모든 객체(conn 제외)에 대해 "자원해제 처리"를 하시오.
    //   조건3)  지정한 SQL문을 사용하여 쿼리를 실행한다.
    //   조건4)  해당 메서드에서 데이터 검색 처리후 결과 목록은 List<City>타입으로 반환한다.
    //   조건5)  필요하다면 추가 메서드를 작성하여 완성할 수 있다.
    private City map(ResultSet rs) throws SQLException {
        return City.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .countryCode(rs.getString("countryCode"))
                .district(rs.getString("district"))
                .population(rs.getInt("population"))
                .build();
    }

    public List<City> selectList(int size) {
        String sql = "SELECT * FROM city ORDER BY population DESC LIMIT ?";
        List<City> cities = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int count = 10;
            int start = (size - 1) * count;
            pstmt.setInt(1, start);
            pstmt.setInt(2, count);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    City city = map(rs);
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    //city테이블에서 검색하여 UI에 반환 처리 기능 구현
    //문제 7-1. selectOne()메서드를 완성하여 데이터 검색 처리를 구현하시오.
    //   조건1)  try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //   조건2)  db처리와 관련된 모든 객체(conn 제외)에 대해 "자원해제 처리"를 하시오.
    //   조건3)  전달받은 City의 id로 검색한다.
    //   조건4)  해당 메서드에서 데이터 검색 처리후 결과 City를 반환한다.
    //   조건5)  필요하다면 추가 메서드를 작성하여 완성할 수 있다.
    public City selectOne(int id) {
        String sql ="select * from city where id = ?";
        City city;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    city = map(rs);
                } else {
                    System.out.println("해당 도시가 없습니다.");
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return city;
    }

    //city, country테이블을 조회하여 UI에 반환 처리 기능 구현
    //문제 8-2. getCountry()메서드를 완성하여  city, Country테이블을 조인 검색 처리를 구현하시오.
    //   조건1)  try-catch를 이용하여 "하나 이상의 예외처리"를 하시오.
    //   조건2)  db처리와 관련된 모든 객체(conn 제외)에 대해 "자원해제 처리"를 하시오.
    //   조건3)  전달받은 Country의 code을 조건으로 city, country테이블을 조인 검색 처리 후 결과 Country를 반환한다.
    //   조건4)  필요하다면 추가 메서드를 작성하여 완성할 수 있다.
    //   조건5)  해당 코드에 대한 검색 결과가 없는 경우 null을 반환한다.
    private Country mapC(ResultSet rs) throws SQLException {
        return Country.builder()
                .code(rs.getString("code"))
                .countryName(rs.getString("countryName"))
                .Continent(rs.getString("Continent"))
                .SurfaceArea(rs.getString("SurfaceArea"))
                .id(rs.getInt("id"))
                .cityName(rs.getString("cityName"))
                .countryCode(rs.getString("countryCode"))
                .district(rs.getString("district"))
                .population(rs.getInt("population"))
                .build();
    }

    public Country getCountry(String code) {
        String sql = "select * FROM city c JOIN country co ON c.CountryCode = co.Code where code = ?";
        Country country;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    country = mapC(rs);
                } else {
                    System.out.println("해당 국가가 없습니다.");
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return country;
    }
}
