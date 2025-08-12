package com.oracle.assetliability.services;

import java.math.BigDecimal;
import java.util.Date;

public class UtilityServiceImpl implements UtilityService {
    @Override
    public BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency) {
        return null;
    }

    @Override
    public String formatDate(Date date) {
        return "";
    }

    @Override
    public boolean isValidRateType(String rateType) {
        return false;
    }
}
