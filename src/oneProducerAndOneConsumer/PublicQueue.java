package oneProducerAndOneConsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by tjsun on 10/20/16.
 */
public class PublicQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        for (int i = 0; i < 10; i ++) {
            if (blockingDeque.isEmpty()) {
                producer.produce(blockingDeque);
                System.out.println("The new product is produced!");
            } else {
                consumer.consume(blockingDeque);
                System.out.println("The product is consumed!");
            }
        }
    }
}
