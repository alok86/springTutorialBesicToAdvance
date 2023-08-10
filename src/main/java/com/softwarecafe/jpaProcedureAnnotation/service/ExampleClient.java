package com.softwarecafe.jpaProcedureAnnotation.service;

import com.softwarecafe.jpaProcedureAnnotation.model.Person;
import com.softwarecafe.jpaProcedureAnnotation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExampleClient {
    @Autowired
    private PersonRepository repo;

    public void run() {
        List<Person> persons = createPersons();
        repo.saveAll(persons);

        System.out.println(" -- getting all persons --");
        Iterable<Person> iterable = repo.findAll();
        List<Person> allPersons = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
        allPersons.forEach(System.out::println);

        Person person = allPersons.get(0);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        String b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        person = allPersons.get(1);
        System.out.printf("-- moving person with id %s to history --%n", person.getId());
        b = repo.movePersonToHistory(person.getId());
        System.out.println("output status: " + b);

        System.out.println("-- getting all persons again --");
        repo.findAll().forEach(System.out::println);

        System.out.println("-- fetching from person history --");
        repo.fetchPersonHistory().forEach(System.out::println);
    }

    private List<Person> createPersons() {
        return Arrays.asList(Person.create("Dana", "Whitley", "464 Gorsuch Drive","dana@example.com","987456321"),
                Person.create("Robin", "Cash", "64 Zella Park","robin@example.com","456321789"),
                Person.create("Chary", "Mess", "112 Yellow Hill","chery@example.com","321456987"),
                Person.create("Rose", "Kantata", "2736 Kooter Lane","rose@example.com","852147963"),
                Person.create("Mike", "Togglie", "111 Cool Dr","mike@example.cm","963258741"));
    }
}
