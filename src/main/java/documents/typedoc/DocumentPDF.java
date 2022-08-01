package documents.typedoc;

import documents.Document;

public class DocumentPDF extends Document {

    private static final Integer TIME_PRINT = 1000;
    private static final String TYPE_NAME_VALUE = "PDF";
    private static final Integer SIZE_PAPER = 15;

    public DocumentPDF(String docName) {
        this.docName = docName;
        this.timePrint = TIME_PRINT;
        this.typeName = TYPE_NAME_VALUE;
        this.sizePaper = SIZE_PAPER;
    }

}
