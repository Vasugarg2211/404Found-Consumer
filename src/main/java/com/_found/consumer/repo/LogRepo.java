package com._found.consumer.repo;
import com._found.consumer.model.RMQMessage;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LogRepo extends ElasticsearchRepository<RMQMessage, String>  {

//    @Query("{\"bool\": {\"must\": [{\"match\": {\"host.name\": \"?0\"}}]}}")
//    List<RMQMessage> findByHostName(String hostName);
//
//    @Query("{\"range\": {\"@timestamp\": {\"gte\": \"?0\", \"lte\": \"?1\"}}}")
//    List<RMQMessage> findByTimestampRange(String startDate, String endDate);

}
