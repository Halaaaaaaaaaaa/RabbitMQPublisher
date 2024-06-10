package com.tisquare.rabbitmq.publisher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    //TODO datetime, level, taskName, hostName, userId, msg
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime dateTime;

    private String level;
    private String taskname;
    private String hostname;
    private String userId;
    private String msg;

    public LogMessage() {}
    
    public LogMessage(LocalDateTime dateTime, String level, String taskname, String hostname, String userId, String msg) {
        this.dateTime = dateTime;
        this.level = level;
        this.taskname = taskname;
        this.hostname = hostname;
        this.userId = userId;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s] [%s] [%s] [%s] - %s",
                dateTime, level, taskname, hostname, userId, msg);
    }

}
