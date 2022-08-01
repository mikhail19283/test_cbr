import dispatcher.Dispatcher;
import documents.typedoc.DocumentPDF;
import documents.typedoc.DocumentTXT;
import documents.typedoc.DocumentXLS;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dispatcher dispatcher = Dispatcher.instance();
        DocumentPDF documentPDF = new DocumentPDF("Документ pdf №1");
        DocumentXLS documentXLS = new DocumentXLS("Документ xls №1");
        DocumentTXT documentTXT = new DocumentTXT("Документ txt №1");

        dispatcher.addToQueue(documentPDF);
        dispatcher.addToQueue(documentXLS);
        Thread.sleep(3500);
        System.out.println(dispatcher.getPrintedDocuments());

        dispatcher.addToQueue(documentTXT);
        Thread.sleep(300);
        dispatcher.stopPrintCurrentDocument();
        System.out.println(dispatcher.getDocumentQueue());

    }
}
