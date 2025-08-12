package com.oracle.assetliability.controllers;

import com.oracle.assetliability.models.AssetType;
import com.oracle.assetliability.repositories.AssetRepository;
import com.oracle.assetliability.models.Asset;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/assets")
public class AssetController {
    private final AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return assetRepository.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("assetType/{assetType}")
    public List<Asset> getAssetsByAssetType(@PathVariable AssetType assetType) {
        return assetRepository.findAssetsByAssetType(assetType);
    }

    @GetMapping("maturityDate/{maturityDate}")
    public List<Asset> getAssetsByMaturityDate(@PathVariable Date maturityDate) {
        return assetRepository.findAssetsByMaturityDateBefore(maturityDate);
    }

    @PostMapping
    public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
        asset.setAssetId(null);
        assetRepository.save(asset);
        return new ResponseEntity<>(asset, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset asset) {
        if (!assetRepository.existsById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        asset.setAssetId(id);
        assetRepository.save(asset);
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAsset(@PathVariable Long id) {
        if (!assetRepository.existsById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        assetRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
