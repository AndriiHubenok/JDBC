package org.example;

import org.flywaydb.core.Flyway;

public class MigrationMain {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:/Users/user/IdeaProjects/JDBC/test", null, null)
                .load();
        flyway.migrate();
    }
}
