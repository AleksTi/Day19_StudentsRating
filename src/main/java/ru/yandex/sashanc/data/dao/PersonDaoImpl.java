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
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Person person = getPersonFromDB(resultSet);
        connection.close();
        return person;
    }

    @Override
    public List<Person> getListPersons(String role) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE role = ?");
        statement.setString(1, role);
        List<Person> persons = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                persons.add(getPersonFromDB(resultSet));
            }
        }
        connection.close();
        return persons;
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
        //person.setPassword();
        person.setRole(resultSet.getString("role"));
        person.setRegDate(resultSet.getDate("datereg"));
        person.setLastLogdate(resultSet.getDate("lastlogdate"));
        person.setConfirmDate(resultSet.getDate("confirmationdate"));
        return person;
    }
}
