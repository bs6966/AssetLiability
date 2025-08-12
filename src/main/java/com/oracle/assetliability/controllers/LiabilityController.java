package com.oracle.assetliability.controllers;

import com.oracle.assetliability.models.Liability;
import com.oracle.assetliability.repositories.LiabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/liabilities")
public class LiabilityController {
    private final LiabilityRepository liabilityRepository;

    public LiabilityController(LiabilityRepository liabilityRepository) {
        this.liabilityRepository = liabilityRepository;
    }

    @GetMapping
    public List<Liability> getAllLiabilities() {
        return liabilityRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Liability> getLiabilityById(@PathVariable Long id) {
        return liabilityRepository.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Liability> addLiability(@RequestBody Liability liability) {
        liability.setLiabilityId(null);
        liabilityRepository.save(liability);
        return new ResponseEntity<>(liability, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Liability> updateLiability(@PathVariable Long id, @RequestBody Liability liability) {
        if (!liabilityRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        liability.setLiabilityId(id);
        liabilityRepository.save(liability);
        return new ResponseEntity<>(liability, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Liability> deleteLiability(@PathVariable Long id) {
        if (!liabilityRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        liabilityRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
