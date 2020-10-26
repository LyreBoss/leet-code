package study.self.message;

/**
 * @author Lgq create on 2020/10/26
 */
public abstract class AbstractConsumer implements Consumer, Runnable {
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
