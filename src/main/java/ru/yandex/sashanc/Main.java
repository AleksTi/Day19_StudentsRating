package ru.yandex.sashanc;

import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.pojo.Person;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        IPersonDao personDao = new PersonDaoImpl();
        Person person = personDao.getPersonById(1);
        System.out.println(
                person.getId() + " " +
                        person.getName() + " " +
                        person.getSurname() + " " +
                        person.getEmail() + " " +
                        person.getRole());

        List<Person> persons = personDao.getListPersons("student");
        for (Person p : persons) {
            System.out.println(
                    p.getId() + " " +
                            p.getName() + " " +
                            p.getSurname() + " " +
                            p.getEmail() + " " +
                            p.getRole());
        }

    }
}
