package documents.typedoc;

import documents.Document;

public class DocumentTXT extends Document {

    private static final Integer TIME_PRINT = 500;
    private static final String TYPE_NAME_VALUE = "TXT";
    private static final Integer SIZE_PAPER = 10;

    public DocumentTXT(String docName) {
        this.docName = docName;
        this.timePrint = TIME_PRINT;
        this.typeName = TYPE_NAME_VALUE;
        this.sizePaper = SIZE_PAPER;
    }

}
