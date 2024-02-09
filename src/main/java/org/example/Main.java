package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxProjectsClient();
        databaseQueryService.findLongestProject();
        databaseQueryService.findMaxSalaryWorker();
        databaseQueryService.findYoungestEldestWokers();
        databaseQueryService.findProjectPrices();
    }
}