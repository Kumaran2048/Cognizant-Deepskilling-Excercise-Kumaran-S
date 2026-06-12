public class SearchAlgorithms {
    
    public static int linearSearch(Product[] products, int productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midProductId = products[mid].getProductId();
            
            if (midProductId == productId) {
                return mid;
            } else if (midProductId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static int linearSearchByName(Product[] products, String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int[] linearSearchByCategory(Product[] products, String category) {
        int[] indices = new int[products.length];
        int count = 0;
        
        for (int i = 0; i < products.length; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                indices[count++] = i;
            }
        }
        
        int[] result = new int[count];
        System.arraycopy(indices, 0, result, 0, count);
        return result;
    }
}
