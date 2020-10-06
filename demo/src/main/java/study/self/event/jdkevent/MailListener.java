package study.self.event.jdkevent;

/**
 * 邮件监听
 *
 * @author Lgq create on 2020/10/6
 */
public class MailListener extends RegisterEventListener {


    @Override
    public void onRegister(RegisterEvent event) {
        System.out.println("开始发送邮件:" + event.toString()
        );
        System.out.println("@@@@@@@@@@");
    }
}
