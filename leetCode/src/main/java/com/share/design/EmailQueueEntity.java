package com.share.design;


/**
 * 枚举单例
 *
 * @author Lgq create on 2020/10/15
 */
public class EmailQueueEntity {


    private EmailQueueEntity() {

    }


    public static EmailQueueEntity getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }


    private enum Singleton {

        INSTANCE;

        private final EmailQueueEntity singleton;


        Singleton() {
            singleton = new EmailQueueEntity();
        }

        public EmailQueueEntity getSingleton() {
            return singleton;
        }
    }

}
