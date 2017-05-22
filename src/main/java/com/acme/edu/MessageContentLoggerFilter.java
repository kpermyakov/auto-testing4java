package com.acme.edu;

public class MessageContentLoggerFilter implements LoggerFilter {
    public boolean filter(String message) {
        return message.contains("ERROR") || message.contains("CRITICAL");
    }
}
