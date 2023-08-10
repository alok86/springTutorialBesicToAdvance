package com.softwarecafe.jpaProcedureAnnotation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "person")
@ToString
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = Person.NamedQuery_MoveToHistory,
                procedureName = "MOVE_TO_HISTORY",
                parameters = {
                        @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.OUT),
                }
        ),
        @NamedStoredProcedureQuery(
                name = Person.NamedQuery_FetchFromHistory,
                procedureName = "FETCH_PERSON_HISTORY",
                resultClasses = Person.class,
                parameters = {
                        @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
                }
        )})
public class Person {
    public static final String NamedQuery_MoveToHistory = "moveToHistory";
    public static final String NamedQuery_FetchFromHistory = "fetchFromHistory";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSON")
    @SequenceGenerator(sequenceName = "SQ_PERSON", allocationSize = 1, name = "SQ_PERSON")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PHONE")
    private String phone;

    public static Person create(String firstName, String lastName, String address, String email, String phone) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setEmailId(email);
        person.setPhone(phone);
        return person;
    }
}