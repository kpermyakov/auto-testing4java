package com.acme.edu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by kpermyakov on 5/18/17.
 */
public class ArrayListTest {

    @Test(timeout = 10000)
    public void shouldSizeIncrementedAndElementSavedAtTailWhenSutIsEmpty() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object dummy = new Object();
        //endregion

        assumeTrue(sut.size() == 0);

        //region When
        sut.add(dummy);
        //endregion

        //region Then
        assertEquals(1, sut.size());

        //endregion

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateNewInstanceWhenCapacityIsNegative() {
        new ArrayList(-1);
    }

    @Test
    public void ShouldUseElementsToStringWhenToString() {
        //region Given
        ArrayList<Object> sut = new ArrayList<Object>();
        Object stub = mock(Object.class);
        when(stub.toString()).thenReturn("Test String");
        sut.add(stub);
        //endregion

        //region When
        String result = sut.toString();
        //endregion

        //region Then
        assertTrue(result.contains("Test String"));
        //endregion
    }

}
