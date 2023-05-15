package user;



/**
 * A class that represents a client user of the application.
 */
public class Client extends Users {
    // Attributes
    private String vatNumber;
    private String phoneNumber;
    private String program; 
    private String bill;
    private String calls;
    private String month;
    private String money;

    // Constructors
    /**
     * Creates a new client with default attributes.
     */
    public Client() {
        super(); // Call the constructor of the superclass (Users)
    }

    /**
     * Creates a new client with the given attributes.
     * @param username The username of the client.
     * @param password The password of the client.
     * @param name The name of the client.
     * @param surname The surname of the client.
     * @param role The role of the client.
     * @param vatNumber The VAT number of the client.
     * @param phoneNumber The phone number of the client.
     */
    public Client(String username, String password, String name, String surname, String role,
                  String vatNumber, String phoneNumber, String program , String bill, String call,String month ,String money) {
        super(username, password, name, surname, role); // Call the constructor of the superclass (Users)
        this.setVatNumber(vatNumber);
        this.setPhoneNumber(phoneNumber);
        this.setProgram(program);
        this.setBill(bill);
        this.setMoney(money);
        this.setCalls(calls);
        this.setMonth(month);
    }
 public Client (String phoneNumber, String bill, String month,String calls) {
	 this.setBill(bill);
	 this.setMonth(month);
	 this.setPhoneNumber(phoneNumber);
	 this.setCalls(calls);
 }
   
 public Client(String username, String password, String name, String surname, String role,
         String vatNumber, String phoneNumber, String program ,String money) {
	 super(username, password, name, surname, role); // Call the constructor of the superclass (Users)
     this.setVatNumber(vatNumber);
     this.setPhoneNumber(phoneNumber);
     this.setProgram(program);
     this.setMoney(money);
 }
 public Client(String username, String password, String name, String surname, String role,
         String vatNumber, String phoneNumber, String program ) {
	 super(username, password, name, surname, role); // Call the constructor of the superclass (Users)
     this.setVatNumber(vatNumber);
     this.setPhoneNumber(phoneNumber);
     this.setProgram(program);
    
 }
 public Client(String money, String bill ) {
	this.setMoney(money);
	this.setBill(bill);
     
    
 }

    // Methods
    /**
     * Views the account of the client.
     * * @throws Exception if there was an error while viewing the account.
     */
    public void viewAccount() {
    	try {
            // Code to view the account of the client goes here
        } catch (Exception e) {
            System.out.println("An error occurred while viewing the account: " + e.getMessage());
        }
    }

    /**
     * Views the bill of the client.
     * * @throws Exception if there was an error while viewing the bill.
     */
    public void viewBill() {
    	  try {
    	        // Code to view the bill of the client goes here
    	    } catch (Exception e) {
    	        System.out.println("An error occurred while viewing the bill: " + e.getMessage());
    	    }
    }

    /**
     * Pays the bill of the client.
     * * @throws Exception if there was an error while paying the bill.
     */
    public void payBill() {
    	try {
            // Code to pay the bill of the client goes here
        } catch (Exception e) {
            System.out.println("An error occurred while paying the bill: " + e.getMessage());
        }
    }


    // Getters and setters
    
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getCalls() {
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
	
	
}
