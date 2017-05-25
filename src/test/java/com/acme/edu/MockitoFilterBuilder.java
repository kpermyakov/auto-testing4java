package com.acme.edu;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MockitoFilterBuilder {
    private boolean isSpy;
    private boolean withFiltering;
    private boolean withLogging;


    public MockitoFilterBuilder isSpy(boolean b) {
        isSpy = b;
        return this;
    }

    public MockitoFilterBuilder withFiltering(boolean b) {
        withFiltering = b;
        return this;
    }

    public MockitoFilterBuilder withLogging(boolean b) {
        withLogging = b;
        return this;
    }

    public MockitoFilterBuilder build() {
        LoggerFilter mockToReturn;
        if (isSpy) {
            mockToReturn = spy(new MessageContentLoggerFilter());
        } else {
            mockToReturn = mock(LoggerFilter.class);
        }

        when(mockToReturn.withFiltering()).thenReturn(withFiltering);
        when(mockToReturn.withLogging()).thenReturn(withLogging);
        return mockToReturn;
    }
}
