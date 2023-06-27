package by.it_academy.jd2.Mk_JD2_98_23.dao.SpringFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextFactory {
    private static ApplicationContext instance;

    private ApplicationContextFactory() {
    }
    public static ApplicationContext getInstance(){
        if (instance == null){
            synchronized (ApplicationContext.class){
                if (instance == null){
                    instance = new ClassPathXmlApplicationContext("applicationContext.xml");
                }
            }
        }
        return instance;
    }
}
