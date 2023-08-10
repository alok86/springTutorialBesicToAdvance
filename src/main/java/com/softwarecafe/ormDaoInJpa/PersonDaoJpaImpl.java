package com.softwarecafe.ormDaoInJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoJpaImpl implements Dao<Person> {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public void save(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Person load(long id) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    @Override
    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        Person employee = em.find(Person.class, id);

        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Person person) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Person> loadAll() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("Select t from Person t")
                .getResultList();
        em.close();
        return persons;
    }
}
