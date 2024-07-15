package com.techgirl.SpringKafka.service.producer;


import com.techgirl.SpringKafka.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    @Value("${kafka-topic}")
    private String topicName;
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(Student student){
        System.out.println("Producing student: " + student.toString());
        kafkaTemplate.send(topicName, student);
    }

}
