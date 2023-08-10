package com.softwarecafe.ormDAOinJPA2.service;

import com.softwarecafe.ormDAOinJPA2.model.Alien;

import java.util.List;


public interface AlienService {
    public void savePerson(Alien person);
    public List<Alien> getAllPersons();
    public Alien getPersonById(long id);
    public void deletePerson(long id);
    public void updatePerson(Alien person);

}
