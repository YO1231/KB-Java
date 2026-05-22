package org.scoula.travel.dao;

import org.scoula.travel.domain.Travel;
import java.util.List;
import java.util.Optional;

public interface TravelDao {
    List<Travel> findAll();
    List<Travel> getPage(int pageNo);
    List<Travel> findByDistrict(String district);
    List<Travel> search(String keyword);
    Optional<Travel> findByNo(Long no);
    void insert(Travel travel);
    void update(Travel travel);
    void delete(Long no);
}
