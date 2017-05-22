package com.acme.edu;

public class Logger {
    private LoggerFilter loggerFilter;
    private LoggerSaver loggerSaver;

    public Logger(LoggerFilter loggerFilter, LoggerSaver loggerSaver) {
        this.loggerFilter = loggerFilter;
        this.loggerSaver = loggerSaver;
    }

    public void log(String message) {
        if (loggerFilter.filter(message)) {
            loggerSaver.save(message);
        }
    }
}
