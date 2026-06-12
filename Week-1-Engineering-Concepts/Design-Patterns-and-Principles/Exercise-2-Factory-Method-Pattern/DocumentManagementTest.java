public class DocumentManagementTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern - Document Management System ===\n");
        
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        wordFactory.processDocument("Report.docx");
        pdfFactory.processDocument("Invoice.pdf");
        excelFactory.processDocument("Budget.xlsx");
        
        System.out.println("\n=== Direct Document Creation and Usage ===");
        Document[] documents = new Document[3];
        documents[0] = wordFactory.createDocument("Document1.docx");
        documents[1] = pdfFactory.createDocument("Document2.pdf");
        documents[2] = excelFactory.createDocument("Document3.xlsx");
        
        System.out.println("\nProcessing all documents:");
        for (Document doc : documents) {
            System.out.println("\nType: " + doc.getDocumentType());
            doc.open();
            doc.save();
            doc.close();
        }
    }
}
