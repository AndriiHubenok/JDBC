package org.example;

import org.example.db.Database;
import org.example.db_results_classes.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() {

        List<LongestProject> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                             "JDBC/src/main/sql/find_longest_project.sql")).useDelimiter(";").next())) {

            while (resultSet.next()) {
                LongestProject project = new LongestProject();
                project.setId(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("id"));
                project.setDuration(resultSet.getInt("month_count"));
                System.out.println(resultSet.getInt("month_count"));
                result.add(project);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {

        List<MaxProjectCountClient> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                             "JDBC/src/main/sql/find_max_projects_client.sql")).useDelimiter(";").next())) {

            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("name"));
                System.out.println(resultSet.getString("name"));
                client.setProjectCount(resultSet.getInt("project_count"));
                System.out.println(resultSet.getInt("project_count"));
                result.add(client);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {

        List<MaxSalaryWorker> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                             "JDBC/src/main/sql/find_max_salary_worker.sql")).useDelimiter(";").next())) {

            while (resultSet.next()) {
                MaxSalaryWorker salary = new MaxSalaryWorker();
                salary.setName(resultSet.getString("name"));
                System.out.println(resultSet.getString("name"));
                salary.setSalary(resultSet.getInt("salary"));
                System.out.println(resultSet.getInt("salary"));
                result.add(salary);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<YoungestEldestWokers> findYoungestEldestWokers() {

        List<YoungestEldestWokers> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                             "JDBC/src/main/sql/find_youngest_eldest_workers.sql")).useDelimiter(";").next())) {

            while (resultSet.next()) {
                YoungestEldestWokers worker = new YoungestEldestWokers();
                worker.setType(resultSet.getString("type"));
                System.out.println(resultSet.getString("type"));
                worker.setName(resultSet.getString("name"));
                System.out.println(resultSet.getString("name"));
                worker.setBirthday(resultSet.getDate("birthday"));
                System.out.println(resultSet.getDate("birthday"));
                result.add(worker);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ProjectPrices> findProjectPrices() {

        List<ProjectPrices> result = new ArrayList<>();

        try (Statement statement = Database.getInstance().getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(
                     new Scanner(Paths.get("C:/Users/user/IdeaProjects/" +
                             "JDBC/src/main/sql/print_project_prices.sql")).useDelimiter(";").next())) {

            while (resultSet.next()) {
                ProjectPrices price = new ProjectPrices();
                price.setId(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("id"));
                price.setPrice(resultSet.getInt("price"));
                System.out.println(resultSet.getInt("price"));
                result.add(price);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
