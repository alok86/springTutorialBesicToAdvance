package com.softwarecafe.ormDaoInJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private Dao<Person> dao;

    public void savePerson(Person person) {
        try {
            dao.save(person);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getAllPersons() {
        try {
            return dao.loadAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person getPersonById(long id) {
        try {
            return dao.load(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletePerson(long id) {
        try {
            dao.delete(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        try {
            dao.update(person);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
