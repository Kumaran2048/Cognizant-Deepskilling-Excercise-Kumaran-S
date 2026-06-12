public class PdfDocument implements Document {
    private String filename;
    
    public PdfDocument(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void open() {
        System.out.println("Opening PDF document: " + filename);
    }
    
    @Override
    public void save() {
        System.out.println("Saving PDF document: " + filename);
    }
    
    @Override
    public void close() {
        System.out.println("Closing PDF document: " + filename);
    }
    
    @Override
    public String getDocumentType() {
        return "PDF Document (.pdf)";
    }
}
