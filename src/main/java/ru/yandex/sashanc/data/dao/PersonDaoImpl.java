package ru.yandex.sashanc.data.dao;

import ru.yandex.sashanc.data.connectiondb.ConnectionManager;
import ru.yandex.sashanc.data.connectiondb.ConnectionManagerJDBCImpl;
import ru.yandex.sashanc.pojo.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements IPersonDao {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();


    @Override
    public int addPerson(Person person) throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("INSERT " +
                    "INTO person (name, surname, email, passwordhash, role, datereg, lastlogdate)  " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                statement.setString(1, person.getName());
                statement.setString(2, person.getSurname());
                statement.setString(3, person.getEmail());
                statement.setString(4, person.getPassword());
                statement.setString(5, person.getRole());
                statement.setDate(6, person.getRegDate());
                statement.setDate(7, person.getRegDate());
                return statement.executeUpdate();
            }
        }
    }

    @Override
    public Person getPersonById(int id) throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?")) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return getPersonFromDB(resultSet);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Person getPersonByEmail(String email) throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE email = ?")) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return getPersonFromDB(resultSet);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Person> getListPersons(String role) throws SQLException {
        try (Connection connection = connectionManager.getConnection()) {
            List<Person> persons;
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE role = ? ORDER BY id")) {
                statement.setString(1, role);
                persons = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        persons.add(getPersonFromDB(resultSet));
                    }
                }
            }
            return persons;
        }
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePersonById(int id) {
        return false;
    }

    private Person getPersonFromDB(ResultSet resultSet) throws SQLException {
        return new Person(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("email"),
                resultSet.getString("passwordhash"),
                resultSet.getString("role"),
                resultSet.getDate("datereg"),
                resultSet.getDate("lastlogdate"),
                resultSet.getDate("confirmationdate")
        );
    }
}
