package com._found.consumer.controller;

import com._found.consumer.model.RMQMessage;
import com._found.consumer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    @GetMapping("/messages/timestamp")
    public Iterable<RMQMessage> getMessagesByTimestampRange(@RequestParam Integer interval) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        // Get the current time in UTC
        ZonedDateTime currentTime = ZonedDateTime.now().withZoneSameInstant(java.time.ZoneOffset.UTC);

        // Define the number of minutes to subtract

        // Subtract x minutes from the current time
        ZonedDateTime timeMinusXMinutes = currentTime.minus(interval, ChronoUnit.MINUTES);

        // Format both times as strings
        String endDate = currentTime.format(formatter);
        String startDate = timeMinusXMinutes.format(formatter);
        System.out.println(startDate + " " + endDate);
        return messageService.getMessagesByTimestampRange(startDate, endDate);
    }

    @GetMapping("/messages/keyword")
    public List<RMQMessage> getMessagesByWord(@RequestParam String word) {
        return messageService.getExactMatch(word);
    }

}
