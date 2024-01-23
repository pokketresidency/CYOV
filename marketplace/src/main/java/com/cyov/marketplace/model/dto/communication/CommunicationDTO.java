package com.cyov.marketplace.model.dto.communication;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Map;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationDTO implements Serializable {


    private String identity;
    private String messageType;
    private String recipient;
    private String messageBody;
    private Map<String, String> additionalDetails;


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
