package com.mycompany.usermanagementconsoleapp;
/* 
When you create a Java package, you're following a commonly accepted convention that helps avoid naming conflicts and organizes your code logically. Here's a breakdown of how the package name like `com.mycompany.usermanagementconsoleapp` came about:

1  Reverse Domain Name Convention: 
   Many organizations own a domain name (like `mycompany.com`). To ensure uniqueness and prevent conflicts with packages from other developers or companies, Java guidelines suggest reversing the domain name in a package. So, `mycompany.com` becomes `com.mycompany`.

2. Project or Application Identifier:  
   After the reversed domain, you add a descriptive name for your project. In this case, `usermanagementconsoleapp` indicates what the application does—a user management console application. This helps clearly identify the purpose and grouping of the related classes within your project.

3. How It Was Set Up in NetBeans: 
   In development environments like NetBeans, when you create a new project, you're often prompted to define a package name. Developers typically follow this naming convention because it standardizes the structure across various projects and organizations.

So, the package name is a combination of organizational identity (using the reversed domain) and a descriptive label for your project. This approach not only makes your code more maintainable but also reduces the chance of naming collisions when integrating with other libraries or systems.
 */

// M0DELING WITH OOP

/*
Making the class public allows it to be used across your entire codebase, which is especially 
important when you're building components (like a User model) that will be referenced from various
parts of your application.
*/

public class User {
    /*
    Private Access Modifier:
    Declaring these variables as private hides them from direct access outside the class. 
    This enforces the principle of -Encapsulation- by ensuring that changes to these variables 
    can only occur through methods specifically designed for that purpose (getters and setters).
    */
    
    //variables
    private int id;
    private String name;
    private String email;
    
    /*
    The constructor is a special method that is called when a new instance of the User class is created.
    -Parameters:
    It takes three parameters (id, name, and email) which are then assigned to the private instance variables using the ‘this.’ keyword.
    - this Keyword:
    Helps distinguish between the instance variable and the parameter with the same name. For example, this.id refers to the instance variable id, while id on its own refers to the parameter.
    */

    //The constructor 
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    /*
    Getters:
    - Methods like getId(), getName(), and getEmail() provide read access to the private variables.
    - These methods return the current value of each variable.
    Setters:
    - Methods like setId(int id), setName(String name), and setEmail(String email) provide write access, allowing the values to be updated.
    - They take a parameter and assign it to the corresponding instance variable.
    Encapsulation in Action:
    By using getters and setters, you gain control over how the fields are accessed and modified.
    */
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(){
        this.name = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(){
        this.email = email;
    }

    /*
    The @Override Annotation
    It makes your intentions explicit to anyone reading your code, indicating that you're replacing 
    or extending the behavior of the inherited method.
    */
    
   @Override
    public String toString(){
        return "User { id=" + id + ", name='" + name + "', email='" + email + "' }";
    }
}
