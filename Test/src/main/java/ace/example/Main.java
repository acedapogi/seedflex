package ace.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> users = objectMapper.readValue(new File("C:/ACE/mydata.json"), new TypeReference<List<User>>() {});

            // (a) Titles assigned to each user
            Map<Integer, List<String>> titlesByUser = new HashMap<Integer, List<String>>();
            for (User user : users) {
                if (!titlesByUser.containsKey(user.getUserId())) {
                    titlesByUser.put(user.getUserId(), new ArrayList<String>());
                }
                titlesByUser.get(user.getUserId()).add(user.getTitle());
            }
            System.out.println("Titles assigned to each user:");
            for (Map.Entry<Integer, List<String>> entry : titlesByUser.entrySet()) {
                System.out.println("User " + entry.getKey() + ": " + entry.getValue());
            }
            //if needed to print new json
            objectMapper.writeValue(new File("C:/ACE/userTitles.json"), users);
            System.out.println("Data has been written to userTitles.json");

            // (b) Users who have completed true
            List<User> usersCompletedTrue = new ArrayList<User>();
            for (User user : users) {
                if (user.isCompleted() && !usersCompletedTrue.contains(user.getUserId())) {
                    usersCompletedTrue.add(user);
                }
            }
            System.out.println("\nUsers with titles who have already completed (true):");
            for (User user : usersCompletedTrue) {
                System.out.println("User " + user.toString());
            }

            //if needed to print new json
            Collections.sort(users);
            objectMapper.writeValue(new File("C:/ACE/userCompleted.json"), usersCompletedTrue);
            System.out.println("Data has been written to userCompleted.json");

            // (c) Users who have completed false
            List<User> usersCompletedFalse = new ArrayList<User>();
            for (User user : users) {
                if (!user.isCompleted() && !usersCompletedFalse.contains(user.getUserId())) {
                    usersCompletedFalse.add(user);
                }
            }
            System.out.println("\nUsers with titles who have not completed (false):");
            for (User user : usersCompletedFalse) {
                System.out.println("User " + user.toString());
            }

            //if needed to print new json
            objectMapper.writeValue(new File("C:/ACE/userNotCompleted.json"), usersCompletedFalse);
            System.out.println("Data has been written to userNotCompleted.json");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
