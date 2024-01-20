package com.cyov.marketplace.model.dto;

import java.util.Map;

public class CommunicationDTO {


    private String identity;
    private String messageType;
    private String recipient;
    private String messageBody;
    private Map<String, String> additionalDetails;

    // Constructors, getters, setters

    public CommunicationDTO() {
        // Default constructor for serialization
    }

    public CommunicationDTO(String messageType,
                            String recipient,
                            String messageBody,
                            Map<String, String> additionalDetails,
                            String identity) {
        this.messageType = messageType;
        this.recipient = recipient;
        this.messageBody = messageBody;
        this.additionalDetails = additionalDetails;
        this.identity = identity;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Map<String, String> getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(Map<String, String> additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    @Override
    public String toString() {
        return "CommunicationDTO{" +
                "messageType='" + messageType + '\'' +
                ", recipient='" + recipient + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", additionalDetails=" + additionalDetails +
                '}';
    }
}
