package oneProducerAndOneConsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by tjsun on 10/20/16.
 */
public class Consumer extends Thread {
    private ArrayBlockingQueue arrayBlockingQueue;

    Consumer(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    public void consume() {
        try {
            sleep(1);
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