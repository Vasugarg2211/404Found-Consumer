package com._found.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "rmq_messages")
public class RMQMessage {
    @Id
    private String id;

    @JsonProperty("@timestamp")
    private String timestamp;

    @JsonProperty("@version")
    private String version;

    private Log log;
    private Event event;
    private Host host;
    private String message;

    // Getters and Setters

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RMQMessage{" +
                "timestamp='" + timestamp + '\'' +
                ", version='" + version + '\'' +
                ", log=" + log +
                ", event=" + event +
                ", host=" + host +
                ", message='" + message + '\'' +
                '}';
    }

    // Nested classes for log, event, and host
    public static class Log {
        private File file;

        // Getters and Setters
        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public static class File {
            private String path;

            // Getters and Setters
            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }
    }

    public static class Event {
        private String original;

        // Getters and Setters
        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }
    }

    public static class Host {
        private String name;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}