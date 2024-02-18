package org.example;

import org.example.db.Database;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseInitService {

    public static void main(String[] args) throws SQLException {

        try (Scanner scanner = new Scanner(Paths.get(System.getProperty("user.dir") +
                "/src/main/sql/init_db.sql"))) {
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                String sql = scanner.next();

                if (!sql.isEmpty()) {
                    try (PreparedStatement statement = Database.getInstance().getConnection().prepareStatement(sql)) {
                        statement.executeUpdate();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }
}
