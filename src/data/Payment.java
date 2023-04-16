
package data;

import java.util.Date;


public class Payment implements DataEntity {
    
    private String cardType;
    private long cardNumber;
    private String cardHolderName;
    private short cardCVV;
    private Date expirationDate;
    
    public Payment(String cardType, long cardNumber, String cardHolderName, short cardCVV, Date expirationDate) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardCVV = cardCVV;
        this.expirationDate = expirationDate;
    }
    
}
