public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern - Logger Test ===\n");
        
        System.out.println("Getting first instance...");
        Logger logger1 = Logger.getInstance();
        
        System.out.println("Getting second instance...");
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Getting third instance...");
        Logger logger3 = Logger.getInstance();
        
        System.out.println("\n=== Verification ===");
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("All instances are the same: " + (logger1 == logger2 && logger2 == logger3));
        
        System.out.println("\n=== Testing Logger Functionality ===");
        logger1.log("This is an informational message");
        logger2.warning("This is a warning message");
        logger3.error("This is an error message");
        
        System.out.println("\n=== Instance Information ===");
        System.out.println("logger1 hash code: " + logger1.hashCode());
        System.out.println("logger2 hash code: " + logger2.hashCode());
        System.out.println("logger3 hash code: " + logger3.hashCode());
    }
}
