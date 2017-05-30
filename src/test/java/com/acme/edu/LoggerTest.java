package com.acme.edu;

import org.junit.*;
import org.junit.rules.ExpectedException;
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
                    .withFiltering(true)
                .build(),
                saverMock
        );

        sut.log("test message");

        verify(saverMock, times(1))
                .save("test message");
    }

    @Test
    public void shouldNotLogWhenFilterNotPassed()
    {
        sut = new Logger(
                new MockitoFilterBuilder()
                .withFiltering(false)
                .build(),
                saverMock
        );
        sut.log("test message");

        verify(saverMock, times(0))
                .save(anyString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSaverIsNull()
    {
        sut = new Logger(
                new MockitoFilterBuilder().build(),
                null
        );
        sut.log("test message");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLoggerIsNull()
    {
        sut = new Logger(
                null,
                saverMock
        );
        sut.log("test message");
    }

}

