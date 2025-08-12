package com.oracle.assetliability.services;

import java.math.BigDecimal;
import java.util.Date;

public interface UtilityService {
    BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency);
    String formatDate(Date date);
    boolean isValidRateType(String rateType);
}
