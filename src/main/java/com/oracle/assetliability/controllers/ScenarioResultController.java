package com.oracle.assetliability.controllers;

import com.oracle.assetliability.models.ScenarioResult;
import com.oracle.assetliability.repositories.ScenarioResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/scenarioResults")
public class ScenarioResultController {
    private final ScenarioResultRepository scenarioResultRepository;

    public ScenarioResultController(ScenarioResultRepository scenarioResultRepository) {
        this.scenarioResultRepository = scenarioResultRepository;
    }

    @GetMapping
    public List<ScenarioResult> getAllScenarioResults() {
        return scenarioResultRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ScenarioResult> getScenarioResultById(@PathVariable Long id) {
        return scenarioResultRepository.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ScenarioResult> createScenarioResult(@RequestBody ScenarioResult scenarioResult) {
        scenarioResult.setScenarioId(null);
        scenarioResultRepository.save(scenarioResult);
        return  new ResponseEntity<>(scenarioResult, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ScenarioResult> updateScenarioResult(@RequestBody ScenarioResult scenarioResult, @PathVariable Long id) {
        if (!scenarioResultRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        scenarioResultRepository.save(scenarioResult);
        return new ResponseEntity<>(scenarioResult, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ScenarioResult> deleteScenarioResult(@PathVariable Long id) {
        if (!scenarioResultRepository.existsById(id)) return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        scenarioResultRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
