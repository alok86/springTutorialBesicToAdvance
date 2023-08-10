package com.softwarecafe.ormDAOinJPA2.client;


import com.softwarecafe.ormDAOinJPA2.model.Alien;
import com.softwarecafe.ormDAOinJPA2.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("client")
public class ExampleClient {
    @Autowired
    AlienService personService;

    public void run(){
        System.out.println("Persisting persons");
        Alien person = Alien.create("anshuman","dixit","mahmoor ganj");
        personService.savePerson(person);
        person = Alien.create("Abhijit","dey","sigra");
        personService.savePerson(person);
        person = Alien.create("Ankit","dubey","Lamahi");
        personService.savePerson(person);

        List<Alien> allPersons = personService.getAllPersons();
        System.out.println("-----------------------------------------");
        System.out.println("Person Loaded"+allPersons);

        person = personService.getPersonById(2);
        System.out.println("Person loaded by id : " + person);

        System.out.println("'updating person address with id 2'");
        person.setAddress("111 Yellow Hill");
        personService.updatePerson(person);

        System.out.println("'Deleting person by id 1'");
        personService.deletePerson(1);

        allPersons = personService.getAllPersons();
        System.out.println("Persons loaded: " + allPersons);

    }

}
