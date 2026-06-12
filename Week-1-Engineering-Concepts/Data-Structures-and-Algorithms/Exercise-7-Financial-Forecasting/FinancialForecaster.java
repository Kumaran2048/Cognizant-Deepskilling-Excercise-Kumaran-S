public class FinancialForecaster {
    
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }
    
    public static double calculateFutureValueMemoization(double presentValue, double growthRate, int years) {
        double[] memo = new double[years + 1];
        return calculateFutureValueMemoHelper(presentValue, growthRate, years, memo);
    }
    
    private static double calculateFutureValueMemoHelper(double presentValue, double growthRate, 
                                                        int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        
        if (memo[years] != 0) {
            return memo[years];
        }
        
        memo[years] = calculateFutureValueMemoHelper(presentValue, growthRate, years - 1, memo) * 
                     (1 + growthRate);
        return memo[years];
    }
    
    public static double calculateFutureValueDP(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        
        double[] dp = new double[years + 1];
        dp[0] = presentValue;
        
        for (int i = 1; i <= years; i++) {
            dp[i] = dp[i - 1] * (1 + growthRate);
        }
        
        return dp[years];
    }
    
    public static double calculateFutureValueFormula(double presentValue, double growthRate, int years) {
        return presentValue * Math.pow(1 + growthRate, years);
    }
    
    public static double predictCAGR(double initialValue, double finalValue, int years) {
        return Math.pow(finalValue / initialValue, 1.0 / years) - 1;
    }
    
    public static double[] forecastMultipleYears(double presentValue, double growthRate, int years) {
        double[] forecast = new double[years + 1];
        
        for (int i = 0; i <= years; i++) {
            forecast[i] = calculateFutureValueFormula(presentValue, growthRate, i);
        }
        
        return forecast;
    }
}
