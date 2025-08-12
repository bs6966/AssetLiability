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
@Table(name = "Assets")
public class Asset {
    @Id
    @GeneratedValue
    private Long assetId;
    private AssetType assetType;
    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private Date maturityDate;
    private String currency;
    private RateType rateType;
}
