package com.oracle.assetliability.repositories;

import com.oracle.assetliability.models.Liability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiabilityRepository extends JpaRepository<Liability,Long> {
//    BigDecimal calculateTotalLiabilitiesValue();
//    List<Liability> getLiabilitiesByCurrency(String currency);
//    List<Liability> getLiabilitiesMaturingBefore(Date date);
}
