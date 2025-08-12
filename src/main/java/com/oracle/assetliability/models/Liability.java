package com.oracle.assetliability.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Libalities")
public class Liability {
    @Id
    @GeneratedValue
    private Long liabilityId;
    private LiabilityType liabilityType;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private Date maturityDate;
    private String currency;
    private RateType rateType;
}
