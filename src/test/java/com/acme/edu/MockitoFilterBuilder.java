package com.acme.edu;

import static org.mockito.Matchers.anyString;
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

    public LoggerFilter build() {
        LoggerFilter mockToReturn = mock(LoggerFilter.class);
        when(mockToReturn.filter(anyString())).thenReturn(withFiltering);

        //when(mockToReturn.withFiltering()).thenReturn(withFiltering);
        // when(mockToReturn.withLogging()).thenReturn(withLogging);
        return mockToReturn;
    }

}
