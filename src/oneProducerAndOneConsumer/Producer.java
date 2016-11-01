package oneProducerAndOneConsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by tjsun on 10/20/16.
 */
class Producer extends Thread {
    private ArrayBlockingQueue arrayBlockingQueue;

    Producer(ArrayBlockingQueue arrayBlockingQueue) {
        this.arrayBlockingQueue = arrayBlockingQueue;
    }

    public void produce() {
        try {
            arrayBlockingQueue.put("The new product produce!");
            System.out.println("The new product is produced! The queue size is " + arrayBlockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.produce();
    }
}