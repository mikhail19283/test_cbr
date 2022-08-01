package dispatcher;

import documents.Document;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PrintedTask implements Runnable {

    private final Queue<Document> documentQueue;
    private final AtomicLong timePrint;
    private final AtomicInteger documentCount;
    private final List<Document> documentList;
    private final Queue<Future<Boolean>> taskQueue;
    private final Future<Boolean> task;

    public PrintedTask(Queue<Document> documentQueue, AtomicLong timePrint, AtomicInteger documentCount, List<Document> documentList, Queue<Future<Boolean>> taskQueue, Future<Boolean> task) {
        this.documentQueue = documentQueue;
        this.timePrint = timePrint;
        this.documentCount = documentCount;
        this.documentList = documentList;
        this.taskQueue = taskQueue;
        this.task = task;
    }

    @Override
    public void run() {
        while (!task.isDone()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Boolean result = task.get();
            if (!result) {
                return;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        Document document = documentQueue.element();
        timePrint.getAndAdd(document.getTimePrint());
        documentCount.getAndAdd(1);
        documentList.add(document);
        System.out.println("Документ " + document.getDocName() + " напечатан, формат: " + document.getTypeName());
        documentQueue.remove();
        taskQueue.remove();

    }
}