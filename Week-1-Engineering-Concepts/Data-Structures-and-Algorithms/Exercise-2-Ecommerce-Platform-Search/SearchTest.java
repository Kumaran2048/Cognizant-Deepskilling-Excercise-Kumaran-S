public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform Search Function ===\n");
        
        Product[] products = {
            new Product(101, "Laptop", "Electronics", 999.99),
            new Product(102, "Mouse", "Electronics", 29.99),
            new Product(103, "Keyboard", "Electronics", 79.99),
            new Product(104, "Monitor", "Electronics", 299.99),
            new Product(105, "T-Shirt", "Clothing", 19.99),
            new Product(106, "Jeans", "Clothing", 59.99),
            new Product(107, "Shoes", "Clothing", 89.99),
            new Product(108, "Book", "Books", 15.99),
            new Product(109, "Pen", "Stationery", 2.99),
            new Product(110, "Notebook", "Stationery", 5.99)
        };
        
        System.out.println("=== Product Inventory ===");
        for (Product product : products) {
            System.out.println(product);
        }
        
        System.out.println("\n=== Linear Search by Product ID ===");
        testLinearSearchById(products, 106);
        testLinearSearchById(products, 111);
        
        Product[] sortedProducts = products.clone();
        java.util.Arrays.sort(sortedProducts, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
        
        System.out.println("\n=== Binary Search by Product ID ===");
        testBinarySearchById(sortedProducts, 106);
        testBinarySearchById(sortedProducts, 111);
        
        System.out.println("\n=== Linear Search by Product Name ===");
        testLinearSearchByName(products, "Laptop");
        testLinearSearchByName(products, "Headphones");
        
        System.out.println("\n=== Linear Search by Category ===");
        testLinearSearchByCategory(products, "Electronics");
        testLinearSearchByCategory(products, "Clothing");
        
        System.out.println("\n=== Performance Analysis ===");
        performanceComparison(products, sortedProducts);
    }
    
    private static void testLinearSearchById(Product[] products, int productId) {
        int index = SearchAlgorithms.linearSearch(products, productId);
        if (index != -1) {
            System.out.println("Found: " + products[index] + " at index " + index);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }
    
    private static void testBinarySearchById(Product[] products, int productId) {
        int index = SearchAlgorithms.binarySearch(products, productId);
        if (index != -1) {
            System.out.println("Found: " + products[index] + " at index " + index);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }
    
    private static void testLinearSearchByName(Product[] products, String name) {
        int index = SearchAlgorithms.linearSearchByName(products, name);
        if (index != -1) {
            System.out.println("Found: " + products[index]);
        } else {
            System.out.println("Product '" + name + "' not found.");
        }
    }
    
    private static void testLinearSearchByCategory(Product[] products, String category) {
        int[] indices = SearchAlgorithms.linearSearchByCategory(products, category);
        if (indices.length > 0) {
            System.out.println("Found " + indices.length + " products in category '" + category + "':");
            for (int index : indices) {
                System.out.println("  - " + products[index]);
            }
        } else {
            System.out.println("No products found in category '" + category + "'.");
        }
    }
    
    private static void performanceComparison(Product[] products, Product[] sortedProducts) {
        System.out.println("Algorithm Comparison for E-commerce Platform:");
        System.out.println("\nLinear Search:");
        System.out.println("  Time Complexity - Best: O(1), Average: O(n), Worst: O(n)");
        System.out.println("  Space Complexity: O(1)");
        System.out.println("  Suitable for: Small datasets, unsorted data");
        System.out.println("  Advantage: Works on unsorted data");
        System.out.println("  Disadvantage: Slow for large datasets");
        
        System.out.println("\nBinary Search:");
        System.out.println("  Time Complexity - Best: O(1), Average: O(log n), Worst: O(log n)");
        System.out.println("  Space Complexity: O(1) iterative, O(log n) recursive");
        System.out.println("  Suitable for: Large sorted datasets");
        System.out.println("  Advantage: Much faster for large datasets");
        System.out.println("  Disadvantage: Requires sorted data");
        
        System.out.println("\nRecommendation for E-commerce Platform:");
        System.out.println("  - Use Binary Search for product ID lookups (IDs are naturally sequential)");
        System.out.println("  - Use indexing/hashing for product names and categories");
        System.out.println("  - Maintain sorted catalogs for efficient searching");
        System.out.println("  - For very large catalogs, consider using database indexes");
    }
}
