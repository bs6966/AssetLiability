package com.oracle.assetliability.services;

import java.util.List;
import java.util.Map;

public class ReportingServiceImpl implements ReportingService {
    @Override
    public Map<String, Object> generateBalanceSheetReport() {
        return Map.of();
    }

    @Override
    public Map<String, Object> generateScenarioComparisonReport() {
        return Map.of();
    }

    @Override
    public List<Map<String, Object>> getMaturityLadder() {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> getAssetLiabilityMismatchReport() {
        return List.of();
    }
}
