package com.softwarecafe.ormSpringDrivenJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HumenDaoJpaImpl implements Dao<Humen> {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Humen humen) {
    em.persist(humen);
    }

    @Override
    public Humen load(long id) {
        Humen humen = em.find(Humen.class,id);
        return humen;
    }

    @Override
    public void delete(long id) {
        Humen humen = em.find(Humen.class,id);
        em.remove(humen);
    }


    @Override
    public void update(Humen humen) {
    em.merge(humen);
    }

    @Override
    public List<Humen> loadAll() {
        List<Humen> humens = em.createQuery("select t from Humen t").getResultList();
        return humens;
    }

    @Override
    public void deleteAll() {
        em.createQuery("delete from Humen");
    }
}
