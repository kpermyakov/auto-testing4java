package com.acme.edu;

import org.junit.*;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LoggerTest {
    private Logger sut;
    private LoggerSaver saverMock;

    @BeforeClass
    public static void setUpCase() {

    }

    @AfterClass
    public static void tearDownCase() {

    }

    @Before
    public void setUp() {
        LoggerFilter filterStub = mock(LoggerFilter.class);
        when(filterStub.filter(anyString())).thenReturn(true);
        saverMock = mock(LoggerSaver.class);

        sut = new Logger(
            filterStub,
            saverMock
        );
    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldLogWhenFilterPass() {
        sut = new Logger(
                new MockitoFilterBuilder()
                    .isSpy(true)
                    .withLogging(false)
                .build(),
                MockitoSaverBuilder
                    .withFormatterFormatString("vggg")

        );

        sut.log("test message");

        verify(saverMock, times(2))
                .save("test message");
    }
}
