public class WordDocument implements Document {
    private String filename;
    
    public WordDocument(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void open() {
        System.out.println("Opening Word document: " + filename);
    }
    
    @Override
    public void save() {
        System.out.println("Saving Word document: " + filename);
    }
    
    @Override
    public void close() {
        System.out.println("Closing Word document: " + filename);
    }
    
    @Override
    public String getDocumentType() {
        return "Word Document (.docx)";
    }
}
