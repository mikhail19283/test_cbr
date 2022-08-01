package documents.typedoc;

import documents.Document;

public class DocumentXLS extends Document {

    private static final Integer TIME_PRINT = 2000;
    private static final String TYPE_NAME_VALUE = "XLS";
    private static final Integer SIZE_PAPER = 20;

    public DocumentXLS(String docName) {
        this.docName = docName;
        this.timePrint = TIME_PRINT;
        this.typeName = TYPE_NAME_VALUE;
        this.sizePaper = SIZE_PAPER;
    }

}
