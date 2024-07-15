package com.techgirl.SpringKafka.service.consumer;

import com.techgirl.SpringKafka.model.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
//    @KafkaListener(topics = "test-topic", groupId = "test")
//    public  void kafkaConsumeJson(Student student){
//        System.out.println("Consuming student : " + student.toString());
//    }


    @KafkaListener(topics = "test-topic", groupId = "test")
    public  void kafkaConsumeString(String message){
        System.out.println("Consuming student : " + message);
    }

}
