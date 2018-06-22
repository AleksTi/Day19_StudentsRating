package service;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import ru.yandex.sashanc.data.dao.ILessonDao;
import ru.yandex.sashanc.data.dao.LessonDaoImpl;
import ru.yandex.sashanc.pojo.Lesson;
import ru.yandex.sashanc.service.ILessonService;
import ru.yandex.sashanc.service.LessonServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LessonServiceImplTest {
    private static final Logger logger = Logger.getLogger(LessonServiceImplTest.class);

    private ILessonService lessonService;

    @Mock
    private ILessonDao lessonDaoMock;

    @BeforeClass
    public static void beforeTests() {
        logger.info("@BeforeClass");
    }

    @Before
    public void before() {
        logger.info("@Before");

        lessonDaoMock = mock(LessonDaoImpl.class);
        this.lessonService = new LessonServiceImpl();
        List<Lesson> lessonsList = new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        Time time = new Time(System.currentTimeMillis());
        lessonsList.add(new Lesson(1, "DataBase", "INSERT", "url:", "201", date, time));
        lessonsList.add(new Lesson(2, "DataBase", "SELECT", "url:", "202", date, time));
        try {
            when(lessonDaoMock.getLessonsByDiscipline(1)).thenReturn(lessonsList);
            when(lessonDaoMock.getLessonsByDiscipline(0)).thenThrow(mock(SQLException.class));
        } catch (SQLException e) {
            logger.info("SQLException in LessonServiceImplTest.before() has occurred " + e);
        }
    }

    @Test
    public void getLessonsByDisciplineTest() {
        logger.info("getLessonsByDisciplineTest()");
        List<Lesson> lessonsList = this.lessonService.getLessonsByDiscipline(1);
        assertNotNull("lessonsListis not null", lessonsList);
        assertEquals("INSERT", lessonsList.get(1).getTheme());
        assertEquals("SELECT", lessonsList.get(2).getTheme());
    }

//    @Test(expected = SQLException.class)
//    public void getLessonsByDisciplineTestWithException(){
//        this.lessonService.getLessonsByDiscipline(0);
//    }
}
