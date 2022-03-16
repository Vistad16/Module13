package javaCore.module13.task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllOpenTasks {
    HttpClient client = HttpClient.newHttpClient();

    public void createJsonWithAllOpenTasksByUserId(int userId) throws IOException, InterruptedException {
        String allOpenTasksJson = getAllOpenTasksByUserId(userId);
        List<OpenTasks> allOpenTasks = getAllOpenTasksFromJson(allOpenTasksJson);
        String jsonFilePath = "src/main/resources/" + "user-" + userId + "-open_todos.json";
        createJsonWithOpenTasks(allOpenTasks, jsonFilePath);
        System.out.println("JSON filepath: " + jsonFilePath);
    }

    private String getAllOpenTasksByUserId(int userId) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private List<OpenTasks> getAllOpenTasksFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        OpenTasks[] tasksArray = gson.fromJson(json, OpenTasks[].class);
        List<OpenTasks> openTasksList = new ArrayList<>(Arrays.asList(tasksArray));
        List<OpenTasks> tasksList = new ArrayList<>();
        for (OpenTasks element : openTasksList) {
            if (!element.completed) {
                tasksList.add(element);
            }
        }
        return tasksList;
    }

    private void createJsonWithOpenTasks(List<OpenTasks> todos, String jsonFilePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(todos.toArray());
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}