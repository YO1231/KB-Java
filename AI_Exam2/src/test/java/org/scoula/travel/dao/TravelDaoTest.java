package org.scoula.travel.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.travel.domain.Travel;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TravelDaoTest {
    TravelDao dao;

    @BeforeEach
    void setUp() {
        dao = new TravelDaoImpl();
    }

    @Test
    @DisplayName("전체 목록 조회 테스트")
    void findAll() {
        List<Travel> list = dao.findAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        System.out.println("Total items: " + list.size());
    }

    @Test
    @DisplayName("상세 조회 테스트")
    void findByNo() {
        Optional<Travel> travel = dao.findByNo(1L);
        assertTrue(travel.isPresent());
        assertEquals("수도권", travel.get().getDistrict());
        assertEquals("인천 개항장역사문화공간", travel.get().getTitle());
    }

    @Test
    @DisplayName("권역별 조회 테스트")
    void findByDistrict() {
        List<Travel> list = dao.findByDistrict("전라권");
        assertFalse(list.isEmpty());
        assertTrue(list.stream().allMatch(t -> t.getDistrict().equals("전라권")));
        System.out.println("전라권 items: " + list.size());
    }

    @Test
    @DisplayName("키워드 검색 테스트")
    void search() {
        List<Travel> list = dao.search("해수욕장");
        assertFalse(list.isEmpty());
        assertTrue(list.stream().allMatch(t -> t.getTitle().contains("해수욕장") || t.getDescription().contains("해수욕장")));
        System.out.println("Search '해수욕장' items: " + list.size());
    }

    @Test
    @DisplayName("추가 테스트")
    void insert() {
        Travel newTravel = Travel.builder()
                .no(999L)
                .district("제주")
                .title("한라산")
                .description("남한에서 가장 높은 산")
                .address("제주도")
                .phone("064-000-0000")
                .build();
        dao.insert(newTravel);

        Optional<Travel> travel = dao.findByNo(999L);
        assertTrue(travel.isPresent());
        assertEquals("한라산", travel.get().getTitle());
    }

    @Test
    @DisplayName("수정 테스트")
    void update() {
        Optional<Travel> travelOpt = dao.findByNo(1L);
        assertTrue(travelOpt.isPresent());
        
        Travel travel = travelOpt.get();
        travel.setTitle("수정된 제목");
        dao.update(travel);

        Optional<Travel> updatedTravel = dao.findByNo(1L);
        assertTrue(updatedTravel.isPresent());
        assertEquals("수정된 제목", updatedTravel.get().getTitle());
    }

    @Test
    @DisplayName("페이지네이션 테스트")
    void getPage() {
        List<Travel> page1 = dao.getPage(1);
        assertEquals(10, page1.size());
        assertEquals(1L, page1.get(0).getNo());

        List<Travel> page2 = dao.getPage(2);
        assertEquals(10, page2.size());
        assertEquals(11L, page2.get(0).getNo());
    }

    @Test
    @DisplayName("삭제 테스트")
    void delete() {
        dao.delete(1L);
        Optional<Travel> travel = dao.findByNo(1L);
        assertFalse(travel.isPresent());
    }
}
