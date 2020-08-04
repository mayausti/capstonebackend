package com.example.demo.Places;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlaceData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String scenery;
    private String arrival;
    private String departure;
    private int budgetLimit;
    private String name;
    private String activities;

    public PlaceData(){}

    public PlaceData (String scenery, String arrival, String departure, int budgetLimit, String name, String activities) {
        this.scenery = scenery;
        this.arrival = arrival;
        this.departure = departure;
        this.budgetLimit = budgetLimit;
        this.name = name;
        this.activities = activities;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getScenery () {
        return this.scenery;
    }

    public void setScenery(String scenery) {
        this.scenery = scenery;
    }

    public String getarrival () {
        return this.arrival;
    }

    public void setarrival(String arrival) {
        this.arrival = arrival;
    }

    public String getdeparture () {
        return this.departure;
    }

    public void setdeparture(String departure) {
        this.departure = departure;
    }

    public int getbudgetLimit () {
        return this.budgetLimit;
    }

    public void setbudgetLimit(int budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    public String getname () {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getactivities () {
        return this.activities;
    }

    public void setactivities(String activities) {
        this.activities = activities;
    }



    
}
