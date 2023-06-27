package by.it_academy.jd2.Mk_JD2_98_23.dao.hibernate;

import by.it_academy.jd2.Mk_JD2_98_23.core.entity.ArtistEntity;
import by.it_academy.jd2.Mk_JD2_98_23.dao.api.IArtistDao;
import by.it_academy.jd2.Mk_JD2_98_23.dao.factory.EntityManagerFactoryVotes;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ArtistHibernateDao implements IArtistDao {

    private EntityManagerFactory factory;

    public ArtistHibernateDao() {
        this.factory = EntityManagerFactoryVotes.getInstance();
    }

    @Override
    public List<ArtistEntity> get() {
        EntityManager manager = factory.createEntityManager();
        String hql = "from ArtistEntity ";
        Session session = manager.unwrap(Session.class);
        Query query = session.createQuery(hql);
        List<ArtistEntity> artistDTOList = query.getResultList();
        return artistDTOList;
    }

    @Override
    public ArtistEntity get(int id) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        ArtistEntity dto = manager.find(ArtistEntity.class,id);
        manager.getTransaction().commit();
        manager.close();
        return dto;
    }

    @Override
    public synchronized ArtistEntity save(ArtistEntity gen) {
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        ArtistEntity dto = new ArtistEntity(gen.getName());
        manager.persist(dto);
        manager.getTransaction().commit();
        manager.close();
        return dto;
    }
}
