package study.self.event.jdkevent;

/**
 * @author Lgq create on 2020/10/6
 */
public class MsgListener extends RegisterEventListener {


    @Override
    public void onRegister(RegisterEvent event) {
        System.out.println("开始发送短信消息：" + event.toString());
        System.out.println("[][][][][][][]");
    }
}
