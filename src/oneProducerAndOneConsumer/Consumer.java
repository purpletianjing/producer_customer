package oneProducerAndOneConsumer;

import java.util.concurrent.BlockingDeque;

/**
 * Created by tjsun on 10/20/16.
 */
public class Consumer {
    public void consume(BlockingDeque<String> queue) throws InterruptedException {
        queue.take();
    }
}
