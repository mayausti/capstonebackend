package com.example.demo.Places;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceData, UUID> {
    List<PlaceData> findAllByOrderByIdAsc();
    PlaceData findOneById(int id);
    List<PlaceData> findByScenery(String scenery);
    List<PlaceData> findBySceneryAndArrival(String scenery, String arrival);
    List<PlaceData> findByBudgetLimitLessThanEqual(int budgetLimit);
    List<PlaceData> findBySceneryAndBudgetLimitLessThanEqual(String scenery, int budgetLimit);
    // List<PlaceData> findBySceneryAndBudgetLimit(String scenery, String budgetLimit);
    // List<PlaceData> findByBudgetLimit(String budgetLimit);
}