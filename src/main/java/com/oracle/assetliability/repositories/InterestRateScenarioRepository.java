package com.oracle.assetliability.repositories;

import com.oracle.assetliability.models.InterestRateScenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRateScenarioRepository extends JpaRepository<InterestRateScenario, Long> {
}
