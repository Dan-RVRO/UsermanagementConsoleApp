package com.mycompany.usermanagementconsoleapp;

import java.util.*; //for collections like HashMap and ArrayList.
import java.nio.file.*;
import java.io.IOException;


public class UserRepository {
    
    /**
    * HashMap is used to store User objects, where the key is the user’s unique ID.
    *
    * Map- type
    * <Integer, User>- the key type for each user
    * users- maps name 
    * new HashMap<>():- initiates an instance of the map
    */ 
    
        //HashMap 
        private Map<Integer, User> users = new HashMap<>();
    
        // Adds new user to ‘users’ map
        
        public void addUser(User user) throws DuplicateUserException {
            if (users.containsKey(user.getId())) {
                throw new DuplicateUserException("User with ID " + user.getId() + " already exists.");
            }
            users.put(user.getId(), user);
        }
        
        public User getUser(int id){
            return users.get(id);
        }
        
        public Collection<User> getAllUsers() {
            return users.values();
        }
        
    /**
    * Saves all user data to a file. Each user is saved on a new line in CSV format (id,name,email).
    *
    * @param fileName The name of the file to save user data.
    * @throws IOException if an error occurs during file writing.
    */
        
        public void saveToFile(String fileName) throws IOException {
            List<String> lines = new ArrayList<>();
            for (User user : users.values()) {
                // Convert user properties to a CSV line.
                lines.add(user.getId() + "," + user.getName() + "," + user.getEmail());
            }
        Files.write(Paths.get(fileName), lines);
        }
        
    /**
    * Loads user data from a file. Expects each line of the file to be in CSV format (id,name,email).
    *
    * @param fileName The name of the file to load user data from.
    * @throws IOException if an error occurs during file reading.
    */
        public void loadFromFile(String fileName) throws IOException {
            if (!Files.exists(Paths.get(fileName))) {
                return; // If the file doesn't exist, there's nothing to load.
            }
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    // Directly add user to the map. (You could also use the addUser() method if you want exception handling.)
                    users.put(id, new User(id, name, email));
                }
            }
        }

}
