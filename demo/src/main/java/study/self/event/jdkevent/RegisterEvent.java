package study.self.event.jdkevent;

import java.util.EventObject;

/**
 * 用户注册事件  基础jdk event
 *
 * @author Lgq create on 2020/10/6
 */
public class RegisterEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RegisterEvent(Object source) {
        super(source);
    }
}
