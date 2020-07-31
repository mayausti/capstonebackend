package com.example.demo.Places;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/result")
public class PlaceController {

    @Autowired
    PlaceRepository repository;

    //Everything for Create and Read Routes

    @GetMapping
    public List<PlaceData> readAllPlaces() {
        return repository.findAll();
    }

    @GetMapping("/{scenery}/{arrival}")
    public List<PlaceData> getByScenery(@PathVariable String scenery, @PathVariable String arrival) {
        return repository.findBySceneryAndArrival(scenery, arrival);
    }

    @GetMapping("/{id}")
    public PlaceData readPlaceById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public PlaceData createPlace(@RequestBody PlaceData place) {
        return repository.save(place);
    }

    //Update and Delete code

    @PutMapping("/{id}")
    public PlaceData updatePlace(@PathVariable UUID id, @RequestBody PlaceData place) {
        PlaceData placeToEdit = repository.findById(id).orElse(null);

        if(placeToEdit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place Data not Found.");
        
        }
        placeToEdit.setScenery(place.getScenery());
        placeToEdit.setarrival(place.getarrival());
        placeToEdit.setdeparture(place.getdeparture());
        placeToEdit.setbudgetLimit(place.getbudgetLimit());
        return repository.save(placeToEdit);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }



}