package ru.yandex.sashanc.service;

import ru.yandex.sashanc.data.dao.ILessonDao;
import ru.yandex.sashanc.data.dao.LessonDaoImpl;
import ru.yandex.sashanc.pojo.Lesson;

import java.sql.SQLException;
import java.util.List;

public class LessonServiceImpl implements ILessonService {
    @Override
    public List<Lesson> getLessonsByDiscipline(int disciplineId) {
        ILessonDao lessonDao = new LessonDaoImpl();
        try {
            return lessonDao.getLessonsByDiscipline(disciplineId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
