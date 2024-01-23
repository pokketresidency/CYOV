package com.cyov.marketplace.kafka.publisher;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;


@Slf4j
@Configuration
@EnableAsync
public class KafkaPublisherService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${spring.kafka.communication-topic}")
    private String COMMUNICATION_TOPIC;


    @Value("${spring.kafka.dlq-topic}")
    private String DLQ_TOPIC;


    @Autowired
    public KafkaPublisherService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessageToCommunicationTopic(String topicName, Object model) {

        try {
            kafkaTemplate.send(topicName, objectMapper.writeValueAsString(model));
            log.info("Successfully sent message: " + model.toString());
        }
        catch (RuntimeException | JsonProcessingException e) {
            log.error("Error Sending message to dlq topic " + model.toString());
        }

    }

    @Async
    public void sendMessageToDLQTopic(Object model) {
        try {

            kafkaTemplate.send(DLQ_TOPIC, objectMapper.writeValueAsString(model));
            log.info("Successfully sent message to cdp topic: " );
        }
        catch (RuntimeException | JsonProcessingException e) {
            log.error("Error Sending message to cdp topic " + e.getMessage());
        }

    }
}
