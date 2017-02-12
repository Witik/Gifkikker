package eu.gillissen.topicus.model;

import javax.persistence.Embeddable;

/**
 * Address information.
 */
@Embeddable
public class Address {

    private String recipient;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
    private String numberAddition;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getNumberAddition() {
        return numberAddition;
    }

    public void setNumberAddition(String numberAddition) {
        this.numberAddition = numberAddition;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
