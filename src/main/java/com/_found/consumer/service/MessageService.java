package com._found.consumer.service;

import com._found.consumer.model.RMQMessage;
import com._found.consumer.repo.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private LogRepo logRepo;

    public Iterable<RMQMessage> fetchAllMessages() {
        Pageable pageable = PageRequest.of(1, 20);
        Page<RMQMessage> messagesPage = logRepo.findAll(pageable);
        return messagesPage.getContent();
    }

//    public List<RMQMessage> fetchMessagesByHostName(String hostName) {
//        return repository.findByHostName(hostName);
//    }
//
//    public List<RMQMessage> getMessagesByTimestampRange(String startDate, String endDate) {
//        return repository.findByTimestampRange(startDate, endDate);
//    }
}
