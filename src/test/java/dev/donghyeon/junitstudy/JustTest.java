package dev.donghyeon.junitstudy;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JustTest {

    @BeforeEach
    void beforeEach(TestInfo testInfo) {

// ...

    }

    @ParameterizedTest
    @ValueSource(strings = "apple")
    void testWithRegularParameterResolver(String argument, TestReporter testReporter) {

        testReporter.publishEntry("argument", argument);
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {

// ...
 }


    }
