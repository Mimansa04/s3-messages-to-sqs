package com.mimansa.rst.queuePOC.service;

import org.springframework.stereotype.Service;

@Service
public class PublishService {

    public void publish(String alertID){
        System.out.println(alertID);
    }
}
