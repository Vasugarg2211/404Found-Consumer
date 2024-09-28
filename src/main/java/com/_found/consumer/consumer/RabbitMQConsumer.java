package com._found.consumer.consumer;


import com._found.consumer.config.RabbitMQConfig;
import com._found.consumer.model.Log;
//import com._found.consumer.repo.LogRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

//    @Autowired
//    private LogRepo logRepo;

    // Listen to the queue for incoming messages
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received message from RabbitMQ: " + message);
        // Process the message here
        // persist
//        logRepo.save(message);
    }
}