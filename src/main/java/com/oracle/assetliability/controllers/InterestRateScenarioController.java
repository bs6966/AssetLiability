package com.oracle.assetliability.controllers;

import com.oracle.assetliability.models.InterestRateScenario;
import com.oracle.assetliability.repositories.InterestRateScenarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/interestRateScenarios")
public class InterestRateScenarioController {
    private final InterestRateScenarioRepository interestRateScenarioRepository;

    public InterestRateScenarioController(InterestRateScenarioRepository interestRateScenarioRepository) {
        this.interestRateScenarioRepository = interestRateScenarioRepository;
    }

    @GetMapping
    public List<InterestRateScenario>  getAllInterestRateScenarios() {
        return interestRateScenarioRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<InterestRateScenario> getInterestRateScenarioById(@PathVariable Long id) {
        return interestRateScenarioRepository.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InterestRateScenario> createInterestRateScenario(@RequestBody InterestRateScenario interestRateScenario) {
        interestRateScenario.setScenarioId(null);
        interestRateScenarioRepository.save(interestRateScenario);
        return new ResponseEntity<>(interestRateScenario, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<InterestRateScenario> updateInterestRateScenario(@PathVariable Long id, @RequestBody InterestRateScenario interestRateScenario) {
        if (!interestRateScenarioRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        interestRateScenario.setScenarioId(id);
        interestRateScenarioRepository.save(interestRateScenario);
        return new ResponseEntity<>(interestRateScenario, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<InterestRateScenario> deleteInterestRateScenario(@PathVariable Long id) {
        if (!interestRateScenarioRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        interestRateScenarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
