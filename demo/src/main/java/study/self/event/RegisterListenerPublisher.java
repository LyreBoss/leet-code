package study.self.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lgq create on 2020/10/6
 */
public class RegisterListenerPublisher {


    private final List<RegisterEventListener> allListeners = new ArrayList<RegisterEventListener>();



    // 添加监听器
    public void addListeners(RegisterEventListener... listeners) {
        allListeners.addAll(Arrays.asList(listeners));
    }

    // 发布事件
    public void publishEvent(RegisterEvent event) {
        for (RegisterEventListener listener : allListeners) {
            listener.onRegister(event); // 监听器触发事件
        }
    }


    public static void main(String[] args) {
        RegisterEvent event = new RegisterEvent("张三");
        RegisterListenerPublisher publisher = new RegisterListenerPublisher();
        publisher.addListeners(new MailListener(), new MsgListener());
        publisher.publishEvent(event);
    }

}
