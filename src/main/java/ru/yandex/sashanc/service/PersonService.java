package ru.yandex.sashanc.service;

import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.pojo.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements IPersonService {
    @Override
    public boolean createPerson(Person person) {
        return false;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public List<Person> getPersons(String role) {
        IPersonDao personDao = new PersonDaoImpl();
        try {
            return personDao.getListPersons(role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int id) {
        return false;
    }
}
