package com.oracle.assetliability.repositories;

import com.oracle.assetliability.models.Asset;
import com.oracle.assetliability.models.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset,Long> {
//    BigDecimal calculateTotalAssetsValue();
    public List<Asset> findAssetsByAssetType(AssetType assetType);
    public List<Asset> findAssetsByMaturityDateBefore(Date maturityDate);
}
