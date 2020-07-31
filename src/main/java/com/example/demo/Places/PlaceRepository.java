package com.example.demo.Places;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceData, UUID> {
    List<PlaceData> findAllByOrderByIdAsc();
    PlaceData findOneById(int id);
    List<PlaceData> findByscenery(String scenery);
    List<PlaceData> findBySceneryAndArrival(String scenery, String arrival);
    List<PlaceData> findByBudgetLimit(int budgetLimit);
}