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

    @Override
    public boolean createPerson(String name, String surname, String email, String password, String role) {
        if ((name != null) && (!name.equals("")) &&
                (email != null) && (!email.equals("")) &&
                (password != null) && (!password.equals("")) &&
                (role.equals("student") || role.equals("teacher") || role.equals("admin")) &&
                (getPersonByEmail(email) == null)) {
            Person person = new Person();
            person.setName(name);
            person.setSurname(surname);
            person.setEmail(email);
            person.setPassword(password);
            if (role.equals("teacher")) {
                person.setRole("ncteacher");
            } else {
                if (role.equals("admin")) {
                    person.setRole("ncadmin");
                } else {
                    person.setRole(role);
                }
            }
            person.setRegDate(new Date(System.currentTimeMillis()));
            IPersonDao personDao = new PersonDaoImpl();
            try {
                return personDao.addPerson(person);
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
        return (person != null) && (person.getPassword().equals(password));
    }
}
