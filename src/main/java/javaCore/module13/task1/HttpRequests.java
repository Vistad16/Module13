package javaCore.module13.task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class HttpRequests {

    HttpClient client = HttpClient.newHttpClient();

    public String createUser(String jsonUserFilePath) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonUserFilePath)))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String updateUserById(int userId, String jsonUserFilePath) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + userId;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofFile(Paths.get(jsonUserFilePath)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public int deleteUserById(int id) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .DELETE()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public String getAllUsers() throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUserById(int id) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users/" + id;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getUserByName(String userName) throws IOException, InterruptedException {
        String uri = "https://jsonplaceholder.typicode.com/users?username=" + userName;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void createJsonWithUser(String jsonUser, String jsonFilePath) {
        User user = createUserFromJson(jsonUser);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(user);
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public void createJsonWithUsers(String jsonUsers, String jsonFilePath) {
        User[] users = createUsersFromJson(jsonUsers);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String outputString = gson.toJson(users);
        try (FileWriter output = new FileWriter(jsonFilePath)) {
            output.write(outputString);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public User createUserFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, User.class);
    }

    public User[] createUsersFromJson(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, User[].class);
    }

}
