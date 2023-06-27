package by.it_academy.jd2.Mk_JD2_98_23.dao.hibernate;

import by.it_academy.jd2.Mk_JD2_98_23.core.entity.VoteEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IVoteDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.factory.EntityManagerFactoryVotes;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class VoteHibernateDao implements IVoteDao {
    private EntityManagerFactory factory;


    public VoteHibernateDao() {
    this.factory = EntityManagerFactoryVotes.getInstance();
    }

    @Override
    public List<VoteEntity> get() {
        EntityManager manager = factory.createEntityManager();
        Session session = manager.unwrap(Session.class);
        String hql = "from VoteEntity";
        Query query = session.createQuery(hql);
        List<VoteEntity> voteDTOList = query.getResultList();
        return voteDTOList;
    }

    @Override
    public VoteEntity get(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        VoteEntity voteDTO= manager.find(VoteEntity.class,id);
        manager.getTransaction().commit();
        manager.close();
        return voteDTO;
    }

    @Override
    public VoteEntity save(VoteEntity entity) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
        return entity;
    }
}
