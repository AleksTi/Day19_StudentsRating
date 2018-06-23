package service;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.sashanc.data.dao.IPersonDao;
import ru.yandex.sashanc.data.dao.PersonDaoImpl;
import ru.yandex.sashanc.pojo.Person;
import ru.yandex.sashanc.service.IPersonService;
import ru.yandex.sashanc.service.PersonService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest {
    private static final Logger logger = Logger.getLogger(PersonServiceTest.class);

    private IPersonDao personDaoMock;

    private IPersonService personServise;
    private List<Person> students;
    private Person person1;

    @BeforeClass
    public static void beforeTests() {
        logger.info("@BeforeClass");
    }

    @Before
    public void before() {
        logger.info("@Before");

        personDaoMock = mock(PersonDaoImpl.class);
        personServise = new PersonService(personDaoMock);
        students = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        person1 = new Person("Name1", "Surname1", "email1", "password1", "student", date, date);
        Person person2 = new Person("Name2", "Surname2", "email2", "password2", "student", date, date);
        students.add(person1);
        students.add(person2);
        try {
            when(personDaoMock.addPerson(person1)).thenReturn(1);
            when(personDaoMock.getPersonByEmail("email1")).thenReturn(person1);
            when(personDaoMock.getListPersons("student")).thenReturn(students);
        } catch (SQLException e) {
            logger.info("SQLException in PersonServiceTest.before() has occurred " + e);
        }
    }

    @Test
    public void createPersonTest() {
        logger.info("createPersonTest()");
        boolean bool = this.personServise.createPerson("Name1", "Surname1", "email1", "password1", "student");
        assertTrue("Person is not created", !bool);
    }

    @Test
    public void getPersonByEmailTest() {
        logger.info("getPersonByEmailTest()");
        Person person = personServise.getPersonByEmail("email1");
        assertNotNull("User is not null", person);
        assertEquals("Name1", person.getName());
        assertEquals("Surname1", person.getSurname());
        assertEquals("email1", person.getEmail());
        assertEquals("password1", person.getPassword());
        assertEquals("student", person.getRole());
    }

    @Test
    public void getPersonsTest() {
        logger.info("getPersonsTest()");
        try {

            List<Person> personList = personServise.getPersons("student");
            verify(personDaoMock, times(1)).getListPersons("student");
            assertNotNull("User is not null", personList);
            assertEquals("Name1", personList.get(0).getName());
            assertEquals("Surname1", personList.get(0).getSurname());
            assertEquals("email1", personList.get(0).getEmail());
            assertEquals("password1", personList.get(0).getPassword());
            assertEquals("student", personList.get(0).getRole());
        } catch (SQLException e) {
            logger.info("SQLException in PersonServiceTest.getPersonsTest() has occurred " + e);
        }

    }


    @Test
    public void checkPersonTest() {
        logger.info("checkPersonTest()");
    }
}
