package com.cyov.marketplace.kafka.consumer;

import com.cyov.marketplace.model.dto.CommunicationDTO;
import com.cyov.marketplace.utils.PublishToDLQ;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.nio.charset.StandardCharsets;


@Slf4j
@KafkaListener(topics = "${spring.kafka.communication-topic}", groupId = "${spring.kafka.communication-group-id}")
@Component
public abstract class BaseKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(BaseKafkaConsumer.class);


    @Value("${spring.kafka.communication-partitioned-topic}")
    private String COMMUNICATION_PARTITIONED_TOPIC;

    @Autowired
    private PublishToDLQ dlqPublisherUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    // The method to be implemented by the subclasses
    protected abstract void processMessage(String key, String value);


    @KafkaHandler
    public void communicationListener(CommunicationDTO event) throws JsonProcessingException {
        try {
            log.info("Event Received from clevertap topic, publishing the event to partitioned topic  - {}", event);
            kafkaTemplate.send(COMMUNICATION_PARTITIONED_TOPIC, event.getIdentity(), objectMapper.writeValueAsString(event));
        }  catch(Exception ex) {
            dlqPublisherUtil.publishEventToDlq(null, String.valueOf(event),
                    "Error while sending to partitioned topic + ");
            log.error("Error occurred while partitioned topic:  Event :  {} , Exception : ", event, ex);
        }
    }

//    @KafkaHandler
//    public void hanldeDeserializedFailureEvents(byte[] event) {
//        try {
//            log.info("hanldeDeserializedFailureEvents --- Messaged received - {}", event);
//            dlqPublisherUtil.publishEventToDlq(null, new String(event, StandardCharsets.UTF_8),
//                    "Error while deserializing the consumed event body byte data before consuming.");
//
//        }  catch(Exception ex) {
//            log.error("Error occurred while pushing to DLQ:  Event :  {} , Exception : ", event, ex);
//
//        }
//    }

}



//public abstract class BaseKafkaConsumer {
//
//    private final Logger logger = LoggerFactory.getLogger(BaseKafkaConsumer.class);
//
//    // The method to be implemented by the subclasses
//    protected abstract void processMessage(String key, String value);
//
//    // This method listens to Kafka and delegates the processing to the subclasses
//    @KafkaListener(topics = "#{'${your.kafka.topics}'.split(',')}",
//            containerFactory = "kafkaListenerContainerFactory")
//    public void listen(ConsumerRecord<String, String> record) {
//        logger.info("Received message on topic {}: {}", record.topic(), record.value());
//        processMessage(record.key(), record.value());
//    }
//}
