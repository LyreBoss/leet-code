package study.self.message;

/**
 * @author Lgq create on 2020/10/26
 */
public abstract class AbstractProducer implements Producer, Runnable {


    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

