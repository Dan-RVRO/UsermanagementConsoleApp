package com.mycompany.usermanagementconsoleapp;

import java.io.IOException;

public class UserManagementConsoleApp {

    public static void main(String[] args) {
        // Instancia un UserRepository
        UserRepository repository = new UserRepository();

        // Attempt to load existing users from file
        try {
            repository.loadFromFile("DBUsers1.txt");
            System.out.println("Users loaded from file.");
        } catch(IOException e) {
            System.out.println("No existing file found or error reading file.");
        }
 
        // Create sample users
        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(2, "Bob", "bob@example.com");

        try {
            // Add users to the repository
            repository.addUser(user1);
            repository.addUser(user2);
            // Attempting to add a duplicate to trigger the custom exception:
            repository.addUser(user1);
        } catch(DuplicateUserException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Use getUser method to retrieve a user with ID 1
        User retrievedUser = repository.getUser(1);
            if (retrievedUser != null) {
                System.out.println("Retrieved user with ID 1: " + retrievedUser);
            } else {
                System.out.println("User with ID 1 not found.");
        }
        // Display all users
        System.out.println("Current Users in Repository:");
        repository.getAllUsers().forEach(System.out::println);

        // Save the current state to a file
        try {
            repository.saveToFile("users.txt");
            System.out.println("Users saved to file.");
        } catch(IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}