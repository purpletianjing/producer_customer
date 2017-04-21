package oneProducerAndOneConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.sleep;

/**
 * Created by tjsun on 10/20/16.
 */
public class Consumer implements Runnable {
    private ArrayBlockingQueue arrayBlockingQueue;

    private ExecutorService executorService;
    private int i = 0;

    Consumer(ArrayBlockingQueue arrayBlockingQueue, ExecutorService singleThreadExecutor) {
        this.arrayBlockingQueue = arrayBlockingQueue;
        this.executorService = singleThreadExecutor;
    }

    public void consume() {
        try {
            sleep(1);
            if (arrayBlockingQueue.isEmpty()) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Producer producer = new Producer(arrayBlockingQueue);
                        producer.produce();
                        String threadName = Thread.currentThread().getName();
                        System.out.println("Thread: threadName is " + threadName);
                    }
                });
            }
            arrayBlockingQueue.take();
            System.out.println("Consume a product! The size is " + arrayBlockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.consume();
    }
}