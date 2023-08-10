package com.softwarecafe.ormDAOinJPA2.dao;

import com.softwarecafe.ormDAOinJPA2.model.Alien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class AlienDaoJpaImpl implements Dao<Alien> {
    @PersistenceUnit
    private EntityManagerFactory emf;


    @Override
    public void save(Alien person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Alien load(long id) {
        EntityManager em = emf.createEntityManager();
        Alien person = em.find(Alien.class, id);
        em.close();
        return person;
    }

    @Override
    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        Alien employee = em.find(Alien.class, id);
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Alien person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<Alien> loadAll() {
        EntityManager em = emf.createEntityManager();
        List<Alien> persons = em.createQuery("Select t from Person t")
                .getResultList();
        em.close();
        return persons;
    }
}
