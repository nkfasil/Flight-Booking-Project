package com.airline.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private static final String TOPIC = "fasil1";
    
    private List<String> changeList = new ArrayList<>();

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(String str) {
    	changeList.add(str);
    }
    
    public List<String> changes() {
    	
    	return changeList;
    }
    
}