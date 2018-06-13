package ru.yandex.sashanc.service;

import ru.yandex.sashanc.pojo.Person;

import java.util.List;

public interface IPersonService {
    boolean createPerson(Person person);

    Person getPersonById(int id);

    List<Person> getPersons(String role);

    boolean updatePerson(Person person);

    boolean deletePerson(int id);
}
