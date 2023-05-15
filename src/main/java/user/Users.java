package user;
import java.io.Serializable;

import javax.security.auth.login.LoginException;

/**
 * A class that represents a user of the application.
 */
public class Users implements Serializable {
	private static final long serialVersionUID =1L;
    // Attributes
    private String username;
    private String password;
    private String name;
    private String surname;
    private String role;

    // Constructors
    /**
     * Creates a new user with default attributes.
     */
    public Users() {
    	this.username="";
    	this.password="";
    	this.name="";
    	this.surname="";
    	this.role="";
    	
    }

    /**
     * Creates a new user with the given attributes.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param name The name of the user.
     * @param surname The surname of the user.
     * @param role The role of the user (e.g. client, seller, administrator).
     */
    public Users(String username, String password, String name, String surname, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    // Getters and setters
    /**
     * Gets the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The username of the user.
     * @throws IllegalArgumentException If the username is null or empty.
     */
    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username;
    }
    /**
     * Gets the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password of the user.
     * @throws IllegalArgumentException If the password is null or empty.
     */
    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.password = password;
    }

    /**
     * Gets the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The name of the user.
     * @throws IllegalArgumentException If the name is null or empty.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Gets the surname of the user.
     * @return The surname of the user.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the user.
     * @param surname The surname of the user.
     * @throws IllegalArgumentException If the surname is null or empty.
     */
    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null or empty.");
        }
        this.surname = surname;
    }
    /**
     * Gets the role of the user.
     * @return The role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * @param role The role of the user.
     * @throws IllegalArgumentException If the role is null or empty.
     */
    public void setRole(String role) {
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }
        this.role = role;
    }

    // Methods
    
    /**
     * Exception thrown when there is an error during user registration.
     * This exception extends the {@link Exception} class and provides a custom message and the original exception as its cause.
     */
    public class RegistrationException extends Exception implements Serializable {
    
    	/**
         * The serial version UID for serialization.
         */
    	private static final long serialVersionUID = 1L;
    	/**
         * Creates a new instance of the RegistrationException class with the specified message and cause.
         *
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method)
         */
        public RegistrationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    /**
     * Registers the user with the given attributes.
     * @throws RegistrationException if there is an error while registering the user.
     */
    public void register() throws RegistrationException {
    	try {
    		// Code to register the user goes here
    		} catch (Exception e) {
    		throw new RegistrationException("Error while registering user.", e);
    		}
    }

    /**
     * Thrown to indicate that there was an error during user login.
     */
    public class LoginException extends Exception implements Serializable {
    	/**
         * The serial version UID for serialization.
         */
    	private static final long serialVersionUID = 1L;
    	/**
         * Constructs a new {@code LoginException} with the specified detail message and cause.
         *
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.
         */
        public LoginException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    /**
     * Logs the user in with the given username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @throws LoginException if there is an error while logging in the user
     */
    public void login(String username, String password)  throws LoginException  {
    	try {
    		// Code to log the user in goes here
    		} catch (Exception e) {
    		throw new LoginException("Error while logging in user.", e);
    		}
    }
    
    /**
     * Thrown to indicate that there was an error during user logout.
     */
    public class LogoutException extends Exception implements Serializable {
    	/**
         * The serial version UID for serialization.
         */
    	private static final long serialVersionUID = 1L;
    	/**
         * Constructs a new {@code LogoutException} with the specified detail message.
         *
         * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
         */
        public LogoutException(String message, Throwable cause) {
            super(message,cause);
        }
    }

    /**
     * Logs the user out.
     * @throws LogoutException if there is an error while logging out the user.
     */
    public void logout() throws LogoutException {
        try {
            // Code to log the user out goes here
        } catch (Exception e) {
            throw new LogoutException("Error while logging out user.", e);
        }
    }
}
