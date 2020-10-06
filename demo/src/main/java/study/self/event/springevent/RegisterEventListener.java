package study.self.event.springevent;

import java.util.EventListener;

/**
 * 用户监听器
 *
 * @author Lgq create on 2020/10/6
 */
public abstract class RegisterEventListener implements EventListener {


    // 用户注册时触发事件
    public abstract void onRegister(RegisterEvent event);
}
