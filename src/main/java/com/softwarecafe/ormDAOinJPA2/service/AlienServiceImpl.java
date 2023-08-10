package com.softwarecafe.ormDAOinJPA2.service;

import com.softwarecafe.ormDAOinJPA2.dao.Dao;
import com.softwarecafe.ormDAOinJPA2.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class AlienServiceImpl implements AlienService {
    @Autowired
    private Dao<Alien> dao;
    public void savePerson(Alien person) {
        try {
            dao.save(person);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Alien> getAllPersons() {
        try {
            return dao.loadAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Alien getPersonById(long id) {
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

    public void updatePerson(Alien person) {
        try {
            dao.update(person);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
