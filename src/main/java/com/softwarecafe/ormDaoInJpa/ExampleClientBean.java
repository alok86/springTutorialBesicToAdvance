package com.softwarecafe.ormDaoInJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExampleClientBean {
    @Autowired
    PersonService personService;

    public void run() {
        System.out.println("'Persisting persons'");
        Person person = Person.create("Dana", "Whitley", "464 Gorsuch Drive");
        personService.savePerson(person);

        person = Person.create("Robin", "Cash", "64 Zella Park");
        personService.savePerson(person);

        List<Person> allPersons = personService.getAllPersons();
        System.out.println("Persons loaded: " + allPersons);

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
