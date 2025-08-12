package com.oracle.assetliability.repositories;

import com.oracle.assetliability.models.ScenarioResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioResultRepository extends JpaRepository<ScenarioResult, Long> {
//    ScenarioResult runScenario(Long scenarioId);
//    BigDecimal computeNetInterestIncomeImpact(Long scenarioId);
//    BigDecimal computeDurationImpact(Long scenarioId);
//    BigDecimal computeLiquidityRatio(Long scenarioId);
}
