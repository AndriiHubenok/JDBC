package org.example;

import org.example.db.Database;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {

        try (Scanner scanner = new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                "JDBC/src/main/sql/populate_db.sql"))) {
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                String sql = scanner.next();

                if (!sql.isEmpty()) {
                    try (Statement statement = Database.getInstance().getConnection().createStatement()) {
                        statement.executeUpdate(sql);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        }
    }
}
