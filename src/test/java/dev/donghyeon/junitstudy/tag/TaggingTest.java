package dev.donghyeon.junitstudy.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
class TaggingTest {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {

    }
}
