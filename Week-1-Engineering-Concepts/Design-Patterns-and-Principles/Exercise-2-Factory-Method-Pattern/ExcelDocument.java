public class ExcelDocument implements Document {
    private String filename;
    
    public ExcelDocument(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void open() {
        System.out.println("Opening Excel document: " + filename);
    }
    
    @Override
    public void save() {
        System.out.println("Saving Excel document: " + filename);
    }
    
    @Override
    public void close() {
        System.out.println("Closing Excel document: " + filename);
    }
    
    @Override
    public String getDocumentType() {
        return "Excel Document (.xlsx)";
    }
}
