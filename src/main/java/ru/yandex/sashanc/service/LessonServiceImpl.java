package ru.yandex.sashanc.service;

import org.apache.log4j.Logger;
import ru.yandex.sashanc.data.dao.ILessonDao;
import ru.yandex.sashanc.data.dao.LessonDaoImpl;
import ru.yandex.sashanc.pojo.Lesson;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class LessonServiceImpl implements ILessonService {
    private static final Logger logger = Logger.getLogger(LessonServiceImpl.class);

    @Override
    public List<Lesson> getLessonsByDiscipline(int disciplineId) {
        ILessonDao lessonDao = new LessonDaoImpl();
        try {
            return lessonDao.getLessonsByDiscipline(disciplineId);
        } catch (SQLException e) {
            logger.info("SQLException in LessonServiceImpl.getLessonsByDiscipline() has occurred " + e);
        }
        return Collections.emptyList();
    }
}
