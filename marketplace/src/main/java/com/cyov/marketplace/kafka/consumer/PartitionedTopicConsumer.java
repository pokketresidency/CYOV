package com.cyov.marketplace.kafka.consumer;

import com.cyov.marketplace.model.dto.CommunicationDTO;
import com.cyov.marketplace.utils.PublishToDLQ;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;


@Component
@Slf4j
@KafkaListener(topics = "${spring.kafka.communication-partitioned-topic}", groupId = "${spring.kafka.communication-partitioned-group-id}", concurrency = "15")
public class PartitionedTopicConsumer {

    private final Logger logger = LoggerFactory.getLogger(PartitionedTopicConsumer.class);


    @Autowired
    private PublishToDLQ dlqPublisherUtil;


    @Autowired
    private ObjectMapper objectMapper;


    @KafkaHandler
    public void handleEvent(String event) throws JsonProcessingException {
        try {

            log.info("Message received - {}", event);

        } catch (HttpServerErrorException exception) {
            log.error("Error occurred :  Event :  {}  Clevertap threw : ", event, exception);
            throw new HttpServerErrorException(exception.getStatusCode());
        } catch(Exception ex) {
            log.error("Error occurred :  Event :  {} , Pushing to DLQ Exception : ", event, ex);
            dlqPublisherUtil.publishEventToDlq(event, objectMapper.writeValueAsString(event),
                    ex.getMessage());
        }
    }
}

