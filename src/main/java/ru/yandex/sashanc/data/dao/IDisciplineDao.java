package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.pojo.Discipline;

import java.sql.SQLException;
import java.util.List;

public interface IDisciplineDao {
    List<Discipline> getDisciplines() throws SQLException;

    boolean addDiscipline(Discipline discipline);
}
