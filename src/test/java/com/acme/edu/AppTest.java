package com.acme.edu;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class AppTest {
    @Test
    public void shouldGetDivisionWhenMainFlow() {
        TestDemoSut sut = new TestDemoSut();
        assertThat(
            sut.divide(1, 2),
            is(0.5)
        );
    }
}
