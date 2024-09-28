package com._found.consumer.service;

import com._found.consumer.model.RMQMessage;
import com._found.consumer.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private LogRepo repository;

    public Iterable<RMQMessage> fetchAllMessages() {
        return repository.findAll();
    }

    public List<RMQMessage> fetchMessagesByHostName(String hostName) {
        return repository.findByHostName(hostName);
    }

    public List<RMQMessage> getMessagesByTimestampRange(String startDate, String endDate) {
        return repository.findByTimestampRange(startDate, endDate);
    }
}
