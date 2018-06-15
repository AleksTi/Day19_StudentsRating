package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.pojo.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface ILessonDao {
    List<Lesson> getLessonsByDiscipline(int disciplineId) throws SQLException;

    List<Lesson> getLessonsByTeacher(int teacherId);

    boolean addLesson(Lesson lesson);

}
