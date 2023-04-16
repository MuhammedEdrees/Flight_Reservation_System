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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public short getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(short cardCVV) {
        this.cardCVV = cardCVV;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
