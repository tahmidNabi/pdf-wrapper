package com.tnob.api;

/**
 * Created by tahmid on 3/20/15.
 */
public class MailingAddress {

    String recipientName;
    String deliveryAddressLine;
    String city;
    String state;
    String zipCode;

    public String getRecipientName() {
        return recipientName;
    }

    public MailingAddress setRecipientName(String recipientName) {
        this.recipientName = recipientName;
        return this;
    }

    public String getDeliveryAddressLine() {
        return deliveryAddressLine;
    }

    public MailingAddress setDeliveryAddressLine(String deliveryAddressLine) {
        this.deliveryAddressLine = deliveryAddressLine;
        return this;
    }

    public String getCity() {
        return city;
    }

    public MailingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public MailingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public MailingAddress setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}
