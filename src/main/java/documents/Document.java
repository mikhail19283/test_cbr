package documents;


public abstract class Document {

    protected String docName;
    protected Integer timePrint;
    protected String typeName;
    protected Integer sizePaper;

    public String getDocName() {
        return docName;
    }

    public Integer getTimePrint() {
        return timePrint;
    }

    public String getTypeName() {
        return typeName;
    }

    public Integer getSizePaper() {
        return sizePaper;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docName='" + docName + '\'' +
                ", timePrint=" + timePrint +
                ", typeName='" + typeName + '\'' +
                ", sizePaper=" + sizePaper +
                '}';
    }

}
