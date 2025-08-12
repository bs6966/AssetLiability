package com.oracle.assetliability.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "InterestRateScenarios")
public class InterestRateScenario {
    @Id
    @GeneratedValue
    private Long scenarioId;
    private String scenarioName;
    private BigDecimal interestRateChange;
    private String description;
}
