public abstract class DocumentFactory {
    public abstract Document createDocument(String filename);
    
    public void processDocument(String filename) {
        Document doc = createDocument(filename);
        System.out.println("\nDocument Type: " + doc.getDocumentType());
        doc.open();
        doc.save();
        doc.close();
    }
}
