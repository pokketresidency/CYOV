package com.cyov.marketplace.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerService extends BaseKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Override
    protected void processMessage(String key, String value) {
        // Implement your specific processing logic here
        logger.info("Processing message with key {}: {}", key, value);
        // Add your business logic here
    }
}
