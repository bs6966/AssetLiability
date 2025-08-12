package com.oracle.assetliability.services;

import java.util.List;
import java.util.Map;

public interface ReportingService {
    Map<String, Object> generateBalanceSheetReport();
    Map<String, Object> generateScenarioComparisonReport();
    List<Map<String, Object>> getMaturityLadder();
    List<Map<String, Object>> getAssetLiabilityMismatchReport();
}
