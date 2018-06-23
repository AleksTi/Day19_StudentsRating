package ru.yandex.sashanc.service;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.pojo.Person;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService implements IPersonService {
    private static final Logger logger = Logger.getLogger(PersonService.class);

    private IPersonDao personDao;

    public PersonService() {
        personDao = new PersonDaoImpl();
    }

    public PersonService(IPersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public boolean createPerson(String name, String surname, String email, String password, String role) {
        if ((name != null) && (!name.equals("")) &&
                (email != null) && (!email.equals("")) &&
                (password != null) && (!password.equals("")) &&
                (role.equals("student") || role.equals("teacher") || role.equals("admin")) &&
                (getPersonByEmail(email) == null)) {
            if (role.equals("teacher")) {
                role = "ncteacher";
            }
            if (role.equals("admin")) {
                role = "ncadmin";
            }
            Date date = new Date(System.currentTimeMillis());
            Person person = new Person(name, surname, email, password, role, date, date);
            try {
                return personDao.addPerson(person) == 1;
            } catch (SQLException e) {
                logger.info("catch block of method \"PersonService.createPerson()\" have done " + e);
            }
        }
        return false;
    }

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public Person getPersonByEmail(String email) {
        if (email != null) {
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
        try {
            return personDao.getListPersons(role);
        } catch (SQLException e) {
            logger.info("catch block of method \"getPersons\" from \"PersonService\" have done " + e);
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
        return (person != null) && (person.getPassword().equals(password));
    }
}
