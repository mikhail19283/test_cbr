package dispatcher;

import documents.Document;

import java.util.Queue;
import java.util.concurrent.Callable;

public class PrintTask implements Callable<Boolean> {

    private final Queue<Document> documentQueue;

    public PrintTask(Queue<Document> documentQueue) {
        this.documentQueue = documentQueue;
    }

    @Override
    public Boolean call() throws Exception {
        try {
            Document document = documentQueue.element();
            Thread.sleep(document.getTimePrint());
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }
}