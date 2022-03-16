package javaCore.module13.task3;

import java.io.IOException;

public class AllOpenTasksTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        AllOpenTasks openTasks = new AllOpenTasks();
        int userId = 5;
        openTasks.createJsonWithAllOpenTasksByUserId(userId);
    }
}
