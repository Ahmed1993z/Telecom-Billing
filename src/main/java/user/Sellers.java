package user;

/**
 * A class that represents a seller user of the application.
 */
public class Sellers extends Users {
    // Constructors
    /**
     * Creates a new seller with default attributes.
     */
    public Sellers() {
        super(); // Call the constructor of the superclass (Users)
    }

    /**
     * Creates a new seller with the given attributes.
     * @param username The username of the seller.
     * @param password The password of the seller.
     * @param name The name of the seller.
     * @param surname The surname of the seller.
     * @param role The role of the seller.
     */
    public Sellers(String username, String password, String name, String surname, String role) {
        super(username, password, name, surname, role); // Call the constructor of the superclass (Users)
    }

 // Methods
    
    /**
    *Registers a new customer.
    *@param customer The customer to be registered.
    *@throws IllegalArgumentException if the customer is null
    */
    
    public void registerCustomer(Client client) {
    if (client == null) {
    throw new IllegalArgumentException("Customer cannot be null");
    }
    // Code to register the customer goes here
    }
    
    /**
    *Issues a customer account.
    *@param customer The customer for whom the account is issued.
    *@throws IllegalArgumentException if the customer is null
    */
    
    public void issueCustomerAccount(Client client) {
    if (client == null) {
    throw new IllegalArgumentException("Customer cannot be null");
    }
    // Code to issue the customer account goes here
    }
    
    /**
    *Changes the customer program.
    *@param customer The customer for whom the program is changed.
    *@param program The new program for the customer.
    *@throws IllegalArgumentException if the customer is null or if the program is null or empty
    */
    
    public void changeCustomerProgram(Client client, String program) {
    if (client == null) {
    throw new IllegalArgumentException("Customer cannot be null");
    }
    if (program == null || program.isEmpty()) {
    throw new IllegalArgumentException("Program cannot be null or empty");
    }
    // Code to change the customer program goes here
    }
    
    /**
     * Checks whether the seller object is valid or not.
     *
     * A seller object is considered valid if it has a non-null and non-empty
     * username, a non-null and non-empty password, and a non-null and non-empty
     * name and surname.
     *
     * @return true if the seller object is valid, false otherwise.
     */
    public boolean isValid() {
        // Check if the username, password, name, surname, and role are not null or empty
        return !(getUsername() == null || getUsername().isEmpty() ||
                 getPassword() == null || getPassword().isEmpty() ||
                 getName() == null || getName().isEmpty() ||
                 getSurname() == null || getSurname().isEmpty() ||
                 getRole() == null || getRole().isEmpty());
    }

}
