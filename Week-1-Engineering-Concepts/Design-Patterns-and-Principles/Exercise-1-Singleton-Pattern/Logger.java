public class Logger {
    private static Logger instance;
    
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }
    
    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
    
    public void warning(String message) {
        System.out.println("[WARNING] " + message);
    }
}
