//package com._found.consumer.config;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.RestClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "org.springframework.data.elasticsearch.repositories")
//public class ElasticsearchConfig {
//
//    @Bean
//    public RestHighLevelClient client() {
//        return RestClients.create(RestClient.builder(
//                new HttpHost("34.93.57.52", 9200, "http")
//        )).rest();
//    }
//
//    @Bean
//    public ElasticsearchRestTemplate elasticsearchRestTemplate() {
//        return new ElasticsearchRestTemplate(client());
//    }
//}
