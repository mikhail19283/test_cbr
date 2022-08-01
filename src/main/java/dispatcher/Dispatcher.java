package dispatcher;

import documents.Document;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Dispatcher {


    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private ExecutorService executorService2 = Executors.newSingleThreadExecutor();

    private Queue<Document> documentQueue = new LinkedList<>();

    private List<Document> printedDocuments = new ArrayList<>();

    private AtomicLong timePrint = new AtomicLong();
    private AtomicInteger documentCount = new AtomicInteger();

    private Queue<Future<Boolean>> taskQueue = new LinkedList<>();

    private static Dispatcher dispatcher;

    private Dispatcher() {

    }

    public static Dispatcher instance() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public Queue<Document> getDocumentQueue() {
        return documentQueue;
    }

    public List<Document> getPrintedDocuments() {
        return printedDocuments;
    }

    public List<Document> stopPrint() {
        executorService.shutdownNow();
        List<Document> documents = new ArrayList<>();
        while (!documentQueue.isEmpty()) {
            documents.add(documentQueue.remove());
        }
        return documents;
    }

    public void addToQueue(Document document) {
        documentQueue.add(document);
        Future<Boolean> result = executorService.submit(new PrintTask(documentQueue));
        executorService2.submit(new PrintedTask(documentQueue, timePrint, documentCount, printedDocuments, taskQueue, result));
        taskQueue.add(result);
    }

    public void stopPrintCurrentDocument() {
        try {
            taskQueue.remove().cancel(true);
            documentQueue.remove();
        } catch (NoSuchElementException e) {
            System.out.println("документ в очереди не найден");
        }

    }

    public Long averageTimePrint() {
        try {
            return timePrint.get() / documentCount.get();
        } catch (ArithmeticException e) {
            System.out.println("Данные будут доступны после печати");
        }
        return null;
    }



}
