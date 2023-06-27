package by.it_academy.jd2.Mk_JD2_98_23.dao.springHibernate;


import by.it_academy.jd2.Mk_JD2_98_23.core.entity.GenrEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IGenreDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.factory.EntityManagerFactoryVotes;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class GenreHibernateDao implements IGenreDao {
    private EntityManagerFactory factory;


    public GenreHibernateDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<GenrEntity> get() {
        EntityManager manager = factory.createEntityManager();
        String hql = "from GenrEntity";
        Session session = manager.unwrap(Session.class);
        Query query = session.createQuery(hql);
        List<GenrEntity> genreDTOList = query.getResultList();
        return genreDTOList;
    }
    @Override
    public GenrEntity get(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GenrEntity dto = manager.find(GenrEntity.class,id);
        manager.getTransaction().commit();
        manager.close();
        return dto;
    }
    @Override
    public synchronized GenrEntity save(GenrEntity gen) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        GenrEntity dto = new GenrEntity(gen.getName());
        manager.persist(dto);
        manager.getTransaction().commit();
        manager.close();
        return dto;
    }
}

