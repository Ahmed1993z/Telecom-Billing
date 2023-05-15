package phone;




/**
*A class to represent a phone charge program with its associated prices and included features.
*/
public class Program {
    private String name;
    private int includedVoiceTime;
    private int includedSMS;
    private int includedData;
    private double fixedPrice;
    private double voiceTimePrice;
    private double smsPrice;
    private double dataPrice;

    /**
    *Constructs a Program object with the given parameters.
    *@param name the name of the program
    *@param includedVoiceTime the number of minutes of voice time included in the program
    *@param includedSMS the number of SMS included in the program
    *@param includedData the amount of data usage included in the program, in MB or GB
    *@param fixedPrice the fixed monthly price of the program
    *@param voiceTimePrice the price per minute of extra voice time beyond the included amount
    *@param smsPrice the price per extra SMS beyond the included amount
    *@param dataPrice the price per extra MB or GB of data usage beyond the included amount
    */
    public Program(String name, int includedVoiceTime, int includedSMS, int includedData, double fixedPrice,
                   double voiceTimePrice, double smsPrice, double dataPrice) {
        this.name = name;
        this.includedVoiceTime = includedVoiceTime;
        this.includedSMS = includedSMS;
        this.includedData = includedData;
        this.fixedPrice = fixedPrice;
        this.voiceTimePrice = voiceTimePrice;
        this.smsPrice = smsPrice;
        this.dataPrice = dataPrice;
    }
    /**
     * Returns the name of the program.
     *
     * @return the name of the program
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the program.
     *
     * @param name the name of the program to set
     * @throws IllegalArgumentException if name is negative
     */

    public void setName(String name) {
    	if (name == null) {
    	    throw new IllegalArgumentException("Name cannot be null.");
    	}
        this.name = name;
    }
    /**
     * Returns the amount of included voice time in minutes for the program.
     *
     * @return the included voice time in minutes
     */

    public int getIncludedVoiceTime() {
        return includedVoiceTime;
    }
  
    
    /**
     * Sets the amount of included voice time in minutes for the program.
     *
     * @param includedVoiceTime the included voice time in minutes to set
     * @throws IllegalArgumentException if includedVoiceTime is negative
     */
    public void setIncludedVoiceTime(int includedVoiceTime) {
        if (includedVoiceTime < 0) {
            throw new IllegalArgumentException("Included voice time cannot be negative.");
        }
        this.includedVoiceTime = includedVoiceTime;
    }
    
    
    /**
    *Gets the number of included SMS messages for the program.
    *@return the number of included SMS messages for the program
    */
    public int getIncludedSMS() {
        return includedSMS;
    }
    
    /**
    * Sets the included SMS for the program.
    *
    * @param includedSMS the number of included SMS messages
    * @throws IllegalArgumentException if includedSMS is negative
    */
   public void setIncludedSMS(int includedSMS) {
       if (includedSMS < 0) {
           throw new IllegalArgumentException("Included SMS cannot be negative.");
       }
       this.includedSMS = includedSMS;
   }
   
    /**
    *Returns the included data for the program.
    *@return the number of included data units
    */
    public int getIncludedData() {
        return includedData;
    }
    
    /**
     * Sets the included data for the program.
     *
     * @param includedData the number of included data units
     * @throws IllegalArgumentException if includedData is negative
     */
    public void setIncludedData(int includedData) {
        if (includedData < 0) {
            throw new IllegalArgumentException("Included data cannot be negative.");
        }
        this.includedData = includedData;
    }
    
 
    /**
    *Returns the fixed price of the program.
    *@return the fixed price of the program
    */
    public double getFixedPrice() {
        return fixedPrice;
    }
    
    /**
     * Sets the fixed price of the program.
     *
     * @param fixedPrice the fixed price of the program to be set
     * @throws IllegalArgumentException if fixedPrice is negative
     */
    public void setFixedPrice(double fixedPrice) {
        if (fixedPrice < 0) {
            throw new IllegalArgumentException("Fixed price cannot be negative.");
        }
        this.fixedPrice = fixedPrice;
    }
    
    
    /**
    *Returns the price per minute of voice time for the program.
    *@return the price per minute of voice time for the program
    */
    public double getVoiceTimePrice() {
        return voiceTimePrice;
    }
    /**
    *Sets the price for voice time service.
    *@param voiceTimePrice the new price for voice time service
    *@throws IllegalArgumentException if the given price is negative
    */
    public void setVoiceTimePrice(double voiceTimePrice) {
        if (voiceTimePrice < 0) {
            throw new IllegalArgumentException("Voice time price cannot be negative.");
        }
        this.voiceTimePrice = voiceTimePrice;
    }
    /**
    *Returns the price per SMS for the program.
    *@return the price per SMS for the program
    */
    public double getSmsPrice() {
        return smsPrice;
    }
    
    /**
    *Sets the price for SMS service.
    *@param smsPrice the new price for SMS service
    *@throws IllegalArgumentException if the given price is negative
    */
    public void setSmsPrice(double smsPrice) {
        if (smsPrice < 0) {
            throw new IllegalArgumentException("SMS price cannot be negative.");
        }
        this.smsPrice = smsPrice;
    }
    /**
    *Returns the price per unit of data for the program.
    *@return the price per unit of data for the program
    */
    
    public double getDataPrice() {
        return dataPrice;
    }
    
    /**
    *Sets the price for data service.
    *@param dataPrice the new price for data service
    *@throws IllegalArgumentException if the given price is negative
    */
    public void setDataPrice(double dataPrice) {
        if (dataPrice < 0) {
            throw new IllegalArgumentException("Data price cannot be negative.");
        }
        this.dataPrice = dataPrice;
    }
    
    /**
    *Checks if the program has valid attributes.
    *@throws IllegalArgumentException if any of the attributes have negative values
    *@return true if all attributes are valid, false otherwise
    */
    public boolean isValid() throws IllegalArgumentException {
    // Check that all attributes have non-negative values
    if (includedVoiceTime < 0 || includedSMS < 0 || includedData < 0 ||
    fixedPrice < 0 || voiceTimePrice < 0 || smsPrice < 0 || dataPrice < 0) {
    throw new IllegalArgumentException("All attributes must have non-negative values.");
    }

    // Check that at least one of the attributes is non-zero
    if (includedVoiceTime == 0 && includedSMS == 0 && includedData == 0 &&
    fixedPrice == 0 && voiceTimePrice == 0 && smsPrice == 0 && dataPrice == 0) {
    throw new IllegalArgumentException("At least one attribute must be non-zero.");
    }

    return true;
    }
    
}