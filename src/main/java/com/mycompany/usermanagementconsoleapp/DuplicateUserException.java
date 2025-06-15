package com.mycompany.usermanagementconsoleapp;

/*
you are using features built into the JDK (and the Java language) to create your custom exception when using -extends-
- Inheritance Using extends:
The keyword extends is a core Java language feature that allows a class to inherit from another class. 
In this case, DuplicateUserException is inheriting from the built-in Exception class. 
This means it gains all the behaviors and properties of the Exception class, such as carrying an error message and stack trace information.
*/
public class DuplicateUserException extends Exception {
    /*
    Purpose of Constructor:
    This is a constructor for the DuplicateUserException class. Constructors initialize 
    new objects. In this case, when a new DuplicateUserException object is created, 
    this constructor ensures that it is instantiated with a detail message that describes the error.
    */
    
    //Constructor
    public DuplicateUserException(String message) {
        
    /*
    ‘super’ is a call to the constructor of the superclass (in this case, Exception)
    The keyword super is used to refer to the immediate superclass of your class.
    When you write super(message); inside a constructor, you are calling the superclass’s constructor 
    that accepts a single String parameter.
    */
        super(message);
    } 
}