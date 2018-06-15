package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.data.connectiondb.ConnectionManager;
import ru.yandex.sashanc.data.connectiondb.ConnectionManagerJDBCImpl;
import ru.yandex.sashanc.pojo.Discipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDaoImpl implements IDisciplineDao {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    @Override
    public List<Discipline> getDisciplines() throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            List<Discipline> disciplines;
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM discipline")) {
                disciplines = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        disciplines.add(getDisciplineFromDB(resultSet));
                    }
                }
            }
            return disciplines;
        }
    }

    @Override
    public boolean addDiscipline(Discipline discipline) {
        return false;
    }

    private Discipline getDisciplineFromDB(ResultSet resultSet) throws SQLException {
        Discipline discipline = new Discipline();
        discipline.setId(resultSet.getInt("id"));
        discipline.setName(resultSet.getString("name"));
        return discipline;
    }
}
