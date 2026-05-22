package org.example;

import org.scoula.cli.App;
import org.scoula.cli.ExitCommand;
import org.scoula.cli.MenuItem;
import org.scoula.travel.service.TravelService;

public class Main extends App {
    private TravelService travelService = new TravelService();

    @Override
    public void init() {
        menu.add(new MenuItem("전체 목록", travelService::showTotalList));
        menu.add(new MenuItem("페이지별 목록", travelService::showPageList));
        menu.add(new MenuItem("권역별 목록", travelService::showDistrictList));
        menu.add(new MenuItem("상세보기", travelService::showDetail));
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
