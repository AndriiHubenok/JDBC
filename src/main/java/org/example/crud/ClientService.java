package org.example.crud;

import org.example.db.Database;
import org.example.db_results_classes.ProjectPrices;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientService {

    private static final String CREATE_CLIENT = "INSERT INTO client(NAME) VALUES (?)";
    private static final String GET_CLIENT = "SELECT name FROM client WHERE id = ?";
    private static final String SET_CLIENT = "UPDATE client SET name = ? WHERE id = ?";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";
    private static final String LIST_CLIENT = "SELECT * FROM client";

    public static long create(String name) throws SQLException {
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(CREATE_CLIENT);
        statement.setString(1, name);
        statement.executeUpdate();
        return getIdByName(name);
    }

    public static String getById(long id) {
        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(GET_CLIENT)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new SQLException("not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setName(long id, String name) {
        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(SET_CLIENT)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteById(long id) {
        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(DELETE_CLIENT)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(LIST_CLIENT)) {

            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                result.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static long getIdByName(String name) {
        String sql = "SELECT id FROM client WHERE name = ?";

        try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("id");
            } else {
                throw new SQLException("not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
