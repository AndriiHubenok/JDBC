package org.example;

import org.example.crud.ClientService;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxProjectsClient();
        databaseQueryService.findLongestProject();
        databaseQueryService.findMaxSalaryWorker();
        databaseQueryService.findYoungestEldestWokers();
        databaseQueryService.findProjectPrices();
        System.out.println(ClientService.getById(1));
        System.out.println(ClientService.getById(5));
        ClientService.setName(7, "Mykyta");
        ClientService.setName(8, "Joshua");
        ClientService.listAll();

    }
}