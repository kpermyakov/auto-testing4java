package com.acme.edu;

import java.util.Date;

public class ConsoleLoggerSaver implements LoggerSaver {
    public void save(String message) {
        System.out.println(new Date() + " : " + message);
    }
}
