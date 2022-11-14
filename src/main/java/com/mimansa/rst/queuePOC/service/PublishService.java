package com.mimansa.rst.queuePOC.service;

import com.mimansa.rst.queuePOC.config.AwsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PublishService {

    private final AwsConfig awsConfig;
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public PublishService(QueueMessagingTemplate queueMessagingTemplate, AwsConfig awsConfig) {
        this.queueMessagingTemplate = queueMessagingTemplate;
        this.awsConfig = awsConfig;
    }

//    HashMap<String, String> headerAttributes = new HashMap<>();
//
//        public void publish(String alertID){
//            headerAttributes.put("message-group-id", "Alert");
//            headerAttributes.put("message-deduplication-id", "Alert");
//        queueMessagingTemplate.send(awsConfig.getEndPoint(),MessageBuilder.withPayload(alertID).copyHeaders(headerAttributes).build());
//
//    }
public void publish(String alertID) {
    queueMessagingTemplate.send(awsConfig.getEndPoint(), MessageBuilder.withPayload(alertID).build());

}
}
