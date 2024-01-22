package com.cyov.marketplace.controller;

import com.cyov.marketplace.kafka.publisher.KafkaPublisherService;
import com.cyov.marketplace.model.dto.communication.CommunicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaPublisherService producerService;

    @PostMapping("/publish/{topic}")
    public void sendMessageToKafkaTopic(@RequestBody CommunicationDTO communicationDTO, @PathVariable("topic") String topic) {
        producerService.sendMessageToCommunicationTopic(topic, communicationDTO);
    }
}
