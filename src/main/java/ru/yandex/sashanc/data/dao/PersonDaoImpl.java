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
    public boolean addPerson(Person person) {
        return false;
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
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setSurname(resultSet.getString("surname"));
        person.setEmail(resultSet.getString("email"));
        person.setPassword(resultSet.getString("passwordhash"));
        person.setRole(resultSet.getString("role"));
        person.setRegDate(resultSet.getDate("datereg"));
        person.setLastLogdate(resultSet.getDate("lastlogdate"));
        person.setConfirmDate(resultSet.getDate("confirmationdate"));
        return person;
    }
}
