package user;


import phone.Program;
/**
 * A class that represents an administrator user of the application.
 */
public class Admin extends Users {
    // Constructors
    /**
     * Creates a new administrator with default attributes.
     */
    public Admin() {
        super(); // Call the constructor of the superclass (Users)
    }

    /**
     * Creates a new administrator with the given attributes.
     * @param username The username of the administrator.
     * @param password The password of the administrator.
     * @param name The name of the administrator.
     * @param surname The surname of the administrator.
     * @param role The role of the administrator.
     */
    public Admin(String username, String password, String name, String surname, String role) {
        super(username, password, name, surname, role); // Call the constructor of the superclass (Users)
    }

    // Methods
    /**
     * Creates a new seller.
     * @param seller The seller to be created.
     * @throws IllegalArgumentException if the seller is null or has invalid data
     */
    public void createSeller(Sellers seller) throws IllegalArgumentException {
        if (seller == null || !seller.isValid()) {
            throw new IllegalArgumentException("Invalid seller data provided.");
        }
        // Code to create the seller goes here
    }

    /**
     * Deletes an existing seller.
     * @param seller The seller to be deleted.
     * @throws IllegalArgumentException if the seller is null or has invalid data
     */
    public void deleteSeller(Sellers seller) throws IllegalArgumentException {
        if (seller == null || !seller.isValid()) {
            throw new IllegalArgumentException("Invalid seller data provided.");
        }
        // Code to delete the seller goes here
    }

    /**
     * Creates a new customer contract plan (program).
     * @param program The program to be created.
     * @throws IllegalArgumentException if the program is null or has invalid data
     */
    public void createCustomerProgram(Program program) throws IllegalArgumentException {
        if (program == null || !program.isValid()) {
            throw new IllegalArgumentException("Invalid program data provided.");
        }
        // Code to create the customer program goes here
    }
}
