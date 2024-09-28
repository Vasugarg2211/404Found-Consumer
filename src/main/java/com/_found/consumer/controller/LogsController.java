package com._found.consumer.controller;

import com._found.consumer.model.RMQMessage;
import com._found.consumer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogsController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public List<RMQMessage> getAllMessages() {
        return (List<RMQMessage>) messageService.fetchAllMessages();
    }

    @GetMapping("/messages/by-host")
    public List<RMQMessage> getMessagesByHost(@RequestParam String hostName) {
        return messageService.fetchMessagesByHostName(hostName);
    }

//    @GetMapping("/messages/timestamp")
//    public Iterable<RMQMessage> getMessagesByTimestampRange(@RequestParam String startDate, @RequestParam String endDate) {
//        return messageService.getMessagesByTimestampRange(startDate, endDate);
//    }

}
