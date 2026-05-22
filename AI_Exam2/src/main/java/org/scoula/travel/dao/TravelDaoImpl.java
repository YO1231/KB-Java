package org.scoula.travel.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.travel.domain.Travel;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    private static final String CSV_PATH = "/travel.csv";
    private List<Travel> travels = new ArrayList<>();

    public TravelDaoImpl() {
        loadCsv();
    }

    private void loadCsv() {
        try (InputStreamReader reader = new InputStreamReader(
                getClass().getResourceAsStream(CSV_PATH), StandardCharsets.UTF_8)) {
            travels = new CsvToBeanBuilder<Travel>(reader)
                    .withType(Travel.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            e.printStackTrace();
            travels = new ArrayList<>();
        }
    }

    @Override
    public List<Travel> findAll() {
        return new ArrayList<>(travels);
    }

    @Override
    public List<Travel> getPage(int pageNo) {
        int pageSize = 10;
        int fromIndex = (pageNo - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, travels.size());

        if (fromIndex >= travels.size() || fromIndex < 0) {
            return new ArrayList<>();
        }

        return new ArrayList<>(travels.subList(fromIndex, toIndex));
    }

    @Override
    public List<Travel> findByDistrict(String district) {
        return travels.stream()
                .filter(t -> t.getDistrict().equals(district))
                .toList();
    }

    @Override
    public List<Travel> search(String keyword) {
        return travels.stream()
                .filter(t -> t.getTitle().contains(keyword) || t.getDescription().contains(keyword))
                .toList();
    }

    @Override
    public Optional<Travel> findByNo(Long no) {
        return travels.stream()
                .filter(t -> t.getNo().equals(no))
                .findFirst();
    }

    @Override
    public void insert(Travel travel) {
        travels.add(travel);
    }

    @Override
    public void update(Travel travel) {
        for (int i = 0; i < travels.size(); i++) {
            if (travels.get(i).getNo().equals(travel.getNo())) {
                travels.set(i, travel);
                return;
            }
        }
    }

    @Override
    public void delete(Long no) {
        travels.removeIf(t -> t.getNo().equals(no));
    }
}
