package by.it_academy.jd2.Mk_JD2_98_23.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryVotes {
    private static EntityManagerFactory instance;

    private EntityManagerFactoryVotes() {
    }
    public static EntityManagerFactory getInstance(){
        if (instance == null){
            synchronized (EntityManagerFactory.class){
                if (instance == null){
                    instance = Persistence.createEntityManagerFactory("tutorial");
                }
            }
        }
        return instance;
    }
}
