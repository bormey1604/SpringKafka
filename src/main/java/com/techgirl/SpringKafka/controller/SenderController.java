package com.techgirl.SpringKafka.controller;import com.techgirl.SpringKafka.model.Student;import com.techgirl.SpringKafka.service.producer.KafkaJsonProducer;import com.techgirl.SpringKafka.service.producer.KafkaStringProducer;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@RequestMapping("/api/v1/messages")public class SenderController {    @Autowired    private KafkaStringProducer kafkaStringProducer;    @Autowired    private KafkaJsonProducer kafkaJsonProducer;    @PostMapping()    public String sendMessage(@RequestBody String message) {        try {            kafkaStringProducer.produceMessage(message);            return "Message sent: " + message;        }catch(Exception ex){            return ex.getMessage();        }    }//    @PostMapping("/json")//    public String sendMessage(@RequestBody Student message) {//        try {//            kafkaJsonProducer.produceMessage(message);//            return "Message sent: " + message;//        }catch(Exception ex){//            return ex.getMessage();//        }//    }}