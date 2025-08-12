package com.oracle.assetliability.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ScenarioResults")
public class ScenarioResult {
    @Id
    @GeneratedValue
    private Long resultId;
    private Long scenarioId; // could be object: InterestRateScenarios scenario;
    private BigDecimal netInterestIncome;
    private BigDecimal durationImpact;
    private BigDecimal liquidityRatio;
    private Date createdAt;
}
