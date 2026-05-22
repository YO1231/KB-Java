package org.scoula.travel.service;

import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.Travel;

import java.util.Comparator;
import java.util.List;

public class TravelService {
    private TravelDao dao = new TravelDaoImpl();

    public void showTotalList() {
        List<Travel> list = dao.findAll();
        list.sort(Comparator.comparing(Travel::getDistrict).thenComparing(Travel::getTitle));

        System.out.println("\n[전체 여행지 목록 (권역별/제목순)]");
        System.out.printf("%-4s %-10s %-20s\n", "번호", "권역", "제목");
        System.out.println("----------------------------------------");
        for (Travel travel : list) {
            System.out.printf("%-4d %-10s %-20s\n", 
                travel.getNo(), travel.getDistrict(), travel.getTitle());
        }
        System.out.println("----------------------------------------");
        System.out.printf("총 %d건의 데이터가 있습니다.\n", list.size());
    }

    public void showPageList() {
        System.out.println("페이지별 목록을 출력합니다.");
    }

    public void showDistrictList() {
        System.out.println("권역별 목록을 출력합니다.");
    }

    public void showDetail() {
        System.out.println("상세보기를 출력합니다.");
    }
}
