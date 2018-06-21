package service;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.yandex.sashanc.service.PersonService;

import static org.junit.Assert.assertTrue;

public class PersonServiceTest {
    private static final Logger logger = Logger.getLogger(PersonServiceTest.class);

    private PersonService personServise;

    @BeforeClass
    public static void beforeTests() {
        logger.info("@BeforeClass");
    }

    @Before
    public void before() {
        logger.info("@Before");
        this.personServise = new PersonService();
    }

    @Test
    public void createPersonTest() {
        logger.info("createPersonTest()");
        boolean bool = this.personServise.createPerson("Name", "Surname", "email", "pass", "admin");
        assertTrue("Person is not created", !bool);
    }
}
