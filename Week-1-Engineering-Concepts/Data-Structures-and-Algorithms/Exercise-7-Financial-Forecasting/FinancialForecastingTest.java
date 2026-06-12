public class FinancialForecastingTest {
    
    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Tool ===\n");
        
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 10;
        
        System.out.println("Initial Investment: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + years + " years\n");
        
        System.out.println("=== Method 1: Simple Recursion ===");
        testSimpleRecursion(presentValue, growthRate, years);
        
        System.out.println("\n=== Method 2: Recursion with Memoization ===");
        testMemoization(presentValue, growthRate, years);
        
        System.out.println("\n=== Method 3: Dynamic Programming ===");
        testDynamicProgramming(presentValue, growthRate, years);
        
        System.out.println("\n=== Method 4: Mathematical Formula ===");
        testMathematicalFormula(presentValue, growthRate, years);
        
        System.out.println("\n=== Multi-Year Forecast ===");
        testMultiYearForecast(presentValue, growthRate, years);
        
        System.out.println("\n=== Time Complexity Analysis ===");
        analyzeTimeComplexity();
        
        System.out.println("\n=== Optimization Recommendations ===");
        printOptimizationRecommendations();
    }
    
    private static void testSimpleRecursion(double presentValue, double growthRate, int years) {
        long startTime = System.nanoTime();
        double result = FinancialForecaster.calculateFutureValueRecursive(presentValue, growthRate, years);
        long endTime = System.nanoTime();
        
        System.out.println("Future Value: $" + String.format("%.2f", result));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(2^n) - Exponential");
        System.out.println("[WARNING] Not suitable for large values of n");
    }
    
    private static void testMemoization(double presentValue, double growthRate, int years) {
        long startTime = System.nanoTime();
        double result = FinancialForecaster.calculateFutureValueMemoization(presentValue, growthRate, years);
        long endTime = System.nanoTime();
        
        System.out.println("Future Value: $" + String.format("%.2f", result));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n) - Linear");
        System.out.println("Space Complexity: O(n) - Cache storage");
        System.out.println("[GOOD] Efficient for moderate values of n");
    }
    
    private static void testDynamicProgramming(double presentValue, double growthRate, int years) {
        long startTime = System.nanoTime();
        double result = FinancialForecaster.calculateFutureValueDP(presentValue, growthRate, years);
        long endTime = System.nanoTime();
        
        System.out.println("Future Value: $" + String.format("%.2f", result));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(n) - Linear");
        System.out.println("Space Complexity: O(n) - DP array");
        System.out.println("[GOOD] Good for iterative approach");
    }
    
    private static void testMathematicalFormula(double presentValue, double growthRate, int years) {
        long startTime = System.nanoTime();
        double result = FinancialForecaster.calculateFutureValueFormula(presentValue, growthRate, years);
        long endTime = System.nanoTime();
        
        System.out.println("Future Value: $" + String.format("%.2f", result));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        System.out.println("Time Complexity: O(log n) - Logarithmic (power operation)");
        System.out.println("Space Complexity: O(1) - Constant");
        System.out.println("[BEST] MOST EFFICIENT APPROACH");
    }
    
    private static void testMultiYearForecast(double presentValue, double growthRate, int years) {
        double[] forecast = FinancialForecaster.forecastMultipleYears(presentValue, growthRate, years);
        
        System.out.println("Year-by-Year Forecast:");
        System.out.println("Year\t|\tFuture Value");
        System.out.println("--------+--------------");
        
        for (int i = 0; i < forecast.length; i++) {
            System.out.println(i + "\t|\t$" + String.format("%.2f", forecast[i]));
        }
        
        System.out.println("\nTotal Growth: " + String.format("%.2f", 
            ((forecast[years] - presentValue) / presentValue) * 100) + "%");
    }
    
    private static void analyzeTimeComplexity() {
        System.out.println("\nTime Complexity Comparison:");
        System.out.println("\n1. Simple Recursion: O(2^n)");
        System.out.println("   - For n=10: ~1024 calls");
        System.out.println("   - For n=20: ~1,048,576 calls");
        System.out.println("   - For n=30: ~1,073,741,824 calls (INFEASIBLE)");
        
        System.out.println("\n2. Memoization: O(n)");
        System.out.println("   - For n=10: 10 calculations");
        System.out.println("   - For n=20: 20 calculations");
        System.out.println("   - For n=30: 30 calculations (FEASIBLE)");
        
        System.out.println("\n3. Dynamic Programming: O(n)");
        System.out.println("   - Iterative approach, no recursion overhead");
        System.out.println("   - Better cache locality");
        
        System.out.println("\n4. Mathematical Formula: O(log n)");
        System.out.println("   - Direct calculation");
        System.out.println("   - No loop or recursion");
        System.out.println("   - FASTEST for all practical purposes");
    }
    
    private static void printOptimizationRecommendations() {
        System.out.println("Key Optimization Strategies:\n");
        
        System.out.println("1. Avoid Simple Recursion");
        System.out.println("   - Causes exponential time complexity");
        System.out.println("   - Results in stack overflow for large n");
        
        System.out.println("\n2. Use Mathematical Formula");
        System.out.println("   - FutureValue = PresentValue * (1 + rate)^years");
        System.out.println("   - O(log n) time complexity");
        System.out.println("   - No memory overhead");
        
        System.out.println("\n3. If Recursion is Necessary");
        System.out.println("   - Apply Memoization (caching results)");
        System.out.println("   - Reduces O(2^n) to O(n)");
        
        System.out.println("\n4. Consider Dynamic Programming");
        System.out.println("   - Iterative bottom-up approach");
        System.out.println("   - Better than recursion for this problem");
        
        System.out.println("\n5. For Production Systems");
        System.out.println("   - Use precomputed tables/caching");
        System.out.println("   - Implement validation and error handling");
        System.out.println("   - Consider database storage for large datasets");
    }
}
