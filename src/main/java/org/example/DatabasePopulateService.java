package org.example;

import org.example.db.Database;

import java.sql.*;

public class DatabasePopulateService {

    private static final String SQL_WORKER = "INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)";
    private static final String SQL_CLIENT = "INSERT INTO client(NAME) VALUES (?)";
    private static final String SQL_PROJECT = "INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)";
    private static final String SQL_PROJECT_WORKER = "INSERT INTO project_worker(PROJECT_ID, WORKER_ID) VALUES (?, ?)";

    public static void main(String[] args) {
        try {
            populateWorkers();
            populateClients();
            populateProjects();
            populateProjectsWorkers();
        } catch (SQLException e) {
            System.out.println("Something went wrong");
        }
    }

    private static void populateWorkers() throws SQLException {
        String[][] workers = {
                {"Andy", "2003-09-01", "Trainee", "500"},
                {"Vladislav", "2004-08-11", "Trainee", "1000"},
                {"Pablo", "2004-02-20", "Junior", "1500"},
                {"Andrew", "2003-12-25", "Junior", "1500"},
                {"Michael", "2000-08-25", "Middle", "2000"},
                {"Frodo", "2000-02-05", "Middle", "2500"},
                {"Tayler", "1999-07-15", "Middle", "2500"},
                {"Jora", "1995-12-09", "Middle", "2750"},
                {"Thomas", "1997-06-17", "Senior", "4500"},
                {"Bohdan", "2004-06-06", "Senior", "6000"}
        };
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(SQL_WORKER);
        for (String[] worker : workers) {
            statement.setString(1, worker[0]);
            statement.setDate(2, Date.valueOf(worker[1]));
            statement.setString(3, worker[2]);
            statement.setInt(4, Integer.parseInt(worker[3]));
            statement.executeUpdate();
        }
    }

    public static void populateClients() throws SQLException {
        String[] clients = {"Marina", "Volodymyr", "Serhii", "Nico", "Anastasiya"};
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(SQL_CLIENT);
        for (String client : clients) {
            statement.setString(1, client);
            statement.executeUpdate();
        }
    }

    public static void populateProjects() throws SQLException {
        String[][] projects = {
                {"1", "2024-01-24", "2024-02-28"},
                {"1", "2024-02-01", "2024-04-01"},
                {"2", "2024-01-25", "2024-06-25"},
                {"2", "2024-02-25", "2024-08-01"},
                {"3", "2024-01-24", "2024-07-28"},
                {"3", "2024-03-01", "2025-03-01"},
                {"4", "2024-01-30", "2024-10-16"},
                {"4", "2024-02-19", "2024-11-08"},
                {"5", "2024-01-26", "2024-12-09"},
                {"5", "2024-03-01", "2026-03-21"}
        };
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(SQL_PROJECT);
        for (String[] project : projects) {
            statement.setInt(1, Integer.parseInt(project[0]));
            statement.setDate(2, Date.valueOf(project[1]));
            statement.setDate(3, Date.valueOf(project[2]));
            statement.executeUpdate();
        }
    }

    public static void populateProjectsWorkers() throws SQLException {
        int[][] projectWorkers = {
                {1, 10}, {1, 1}, {2, 9}, {2, 2}, {3, 8}, {3, 3}, {4, 7}, {4, 4},
                {5, 6}, {5, 5}, {6, 1}, {6, 3}, {6, 5}, {7, 2}, {7, 4}, {7, 6},
                {8, 10}, {8, 9}, {8, 8}, {8, 7}, {9, 1}, {9, 2}, {9, 3}, {9, 4},
                {9, 5}, {10, 6}
        };
        PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(SQL_PROJECT_WORKER);
        for (int[] projectWorker : projectWorkers) {
            statement.setInt(1, projectWorker[0]);
            statement.setInt(2, projectWorker[1]);
            statement.executeUpdate();
        }
    }

}
