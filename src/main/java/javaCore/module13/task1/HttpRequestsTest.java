package javaCore.module13.task1;

import java.io.IOException;

public class HttpRequestsTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        String jsonUserId = "src/main/resources/user_id.json";
        String jsonUserName = "src/main/resources/user_name.json";
        String jsonAllUsers = "src/main/resources/all_users.json";
        String jsonUserNew = "src/main/resources/new_user.json";
        String jsonUserUpdated = "src/main/resources/updated_user.json";

        HttpRequests httpRequests = new HttpRequests();


        //1
        String newUser = httpRequests.createUser(jsonUserId);
        System.out.println("New user:\n" + newUser);
        httpRequests.createJsonWithUser(newUser, jsonUserNew);

        //2
        int updatedUserId = 3;
        String UpdatedUser = httpRequests.updateUserById(updatedUserId, jsonUserId);
        System.out.println("Updated user:\n" + UpdatedUser);
        httpRequests.createJsonWithUser(UpdatedUser, jsonUserUpdated);

        //3
        int deleteUserId = 5;
        System.out.println("User with id = " + deleteUserId + "; delete status - " + httpRequests.deleteUserById(deleteUserId));

        //4
        System.out.println("List with all users:\n" + httpRequests.getAllUsers());
        httpRequests.createJsonWithUsers(httpRequests.getAllUsers(), jsonAllUsers);

        //5
        int userId = 1;
        String user = httpRequests.getUserById(userId);
        System.out.println("User " + userId + ":\n" + user);
        httpRequests.createJsonWithUser(user, jsonUserId);

        //6
        String userName = "Leopoldo_Corkery";
        String userUsername = httpRequests.getUserByName(userName);
        System.out.println("User with name \"" + userName + "\":\n" + userUsername);
        httpRequests.createJsonWithUsers(userUsername, jsonUserName);

    }

}
