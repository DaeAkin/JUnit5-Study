package dev.donghyeon.junitstudy.customresolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(RandomParametersExtension.class)
class MyRandomParameterTest {

    @Test
    void injectsInteger(@RandomParametersExtension.Random int i, @RandomParametersExtension.Random int j) {

        assertNotEquals(i, j);
    }

    @Test
    void injectsDouble(@RandomParametersExtension.Random double d) {
        assertEquals(0.0, d, 1.0);
    }

}