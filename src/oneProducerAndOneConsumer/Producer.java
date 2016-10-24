package oneProducerAndOneConsumer;

import java.util.concurrent.BlockingDeque;

/**
 * Created by tjsun on 10/20/16.
 */
public class Producer {
    public void produce(BlockingDeque<String> queue) throws InterruptedException {
        queue.put("The new product produce!");
    }
}
