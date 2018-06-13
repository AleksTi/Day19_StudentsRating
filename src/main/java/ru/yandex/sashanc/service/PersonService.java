package ru.yandex.sashanc.service;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.pojo.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements IPersonService {
    private static final Logger logger = Logger.getLogger(PersonService.class);
    @Override
    public boolean createPerson(Person person) {
        return false;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public Person getPersonByEmail(String email) {
        if (email != null) {
            IPersonDao personDao = new PersonDaoImpl();
            try {
                return personDao.getPersonByEmail(email);
            } catch (SQLException e) {
                logger.info("catch block of method \"getPersonByEmail\" from \"PersonService\" have done " + e);
            }
        }
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

    @Override
    public boolean checkPerson(Person person, String password) {
        return person != null && person.getPassword().equals(password);
    }
}
