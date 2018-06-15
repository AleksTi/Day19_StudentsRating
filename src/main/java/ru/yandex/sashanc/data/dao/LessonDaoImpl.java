package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.data.connectiondb.ConnectionManager;
import ru.yandex.sashanc.data.connectiondb.ConnectionManagerJDBCImpl;
import ru.yandex.sashanc.pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDaoImpl implements ILessonDao {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    @Override
    public List<Lesson> getLessonsByDiscipline(int disciplineId) throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            List<Lesson> lessons;
            try (PreparedStatement statement = connection.prepareStatement("SELECT d.id AS disId, d.name AS name, " +
                    "p.id AS teacherId, p.name AS teacherName, p.surname AS teacherSurname, l.id AS id,\n" +
                    "        l.theme, l.place, l.date, l.time, l.link FROM person p " +
                    "INNER JOIN person_discipline pd ON p.id = pd.person_id\n" +
                    "  RIGHT OUTER JOIN discipline d ON pd.discipline_id = d.id " +
                    "INNER JOIN lesson l ON d.id = l.discipline_id WHERE d.id = ? ORDER BY d.id;")) {
                statement.setInt(1, disciplineId);
                lessons = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        lessons.add(getLessonFromDB(resultSet));
                    }
                }
            }
            return lessons;
        }
    }

    @Override
    public List<Lesson> getLessonsByTeacher(int teacherId) {
        return null;
    }

    @Override
    public boolean addLesson(Lesson lesson) {
        return false;
    }

    private Lesson getLessonFromDB(ResultSet resultSet) throws SQLException {
        Lesson lesson = new Lesson();
        lesson.setId(resultSet.getInt("id"));
        lesson.setDisciplineName(resultSet.getString("name"));
        lesson.setTheme(resultSet.getString("theme"));
        lesson.setPlace(resultSet.getString("place"));
        lesson.setDate(resultSet.getDate("date"));
        lesson.setTime(resultSet.getTime("time"));
        lesson.setLink(resultSet.getString("link"));
        lesson.setTeacherName(resultSet.getString("teacherName"));
        lesson.setTeacherSurname(resultSet.getString("teacherSurname"));
        return lesson;
    }
}
