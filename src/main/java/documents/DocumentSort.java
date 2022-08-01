package documents;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentSort {

    public static List<Document> byPrintQueue(List<Document> documentList) {
        return documentList;
    }

    public static List<Document> byDocumentType(List<Document> documentList){
        return documentList.stream().sorted(Comparator.comparing(Document::getTypeName)).collect(Collectors.toUnmodifiableList());
    }

    public static List<Document> byTimePrint(List<Document> documentList){
        return documentList.stream().sorted(Comparator.comparing(Document::getTimePrint)).collect(Collectors.toUnmodifiableList());
    }

    public static List<Document> bySizePaper(List<Document> documentList){
        return documentList.stream().sorted(Comparator.comparing(Document::getSizePaper)).collect(Collectors.toUnmodifiableList());
    }

}
