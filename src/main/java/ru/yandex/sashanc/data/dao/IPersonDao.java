package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.pojo.Person;

import java.sql.SQLException;
import java.util.List;

public interface IPersonDao {
    public boolean addPerson(Person person) throws SQLException;

    public Person getPersonById(int id) throws SQLException;

    public List<Person> getListPersons(String role) throws SQLException;

    public boolean updatePerson(Person person);

    public boolean deletePersonById(int id);

    public Person getPersonByEmail(String email) throws SQLException;
}
