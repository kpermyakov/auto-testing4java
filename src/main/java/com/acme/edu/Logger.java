package com.acme.edu;

public class Logger {
    private LoggerFilter loggerFilter;
    private LoggerSaver loggerSaver;

    public Logger(LoggerFilter loggerFilter, LoggerSaver loggerSaver) {
        this.loggerFilter = loggerFilter;
        this.loggerSaver = loggerSaver;
    }

    public void log(String message) {
        if (loggerFilter == null) throw new IllegalArgumentException("logger filter is null");
        if (loggerSaver == null) throw new IllegalArgumentException("logger saver is null");
        if (loggerFilter.filter(message)) {
            loggerSaver.save(message);
        }
    }
}
