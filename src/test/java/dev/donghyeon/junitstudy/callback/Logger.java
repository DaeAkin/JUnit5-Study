package dev.donghyeon.junitstudy.callback;

import org.junit.jupiter.api.extension.Extension;

import java.util.function.Supplier;

class Logger {

    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    static void beforeAllMethod(String text) {
        log(() -> "@BeforeAll " + text);
    }

    static void beforeEachCallback(Extension extension) {
        log(() -> "  " + extension.getClass().getSimpleName() + ".beforeEach()");
    }

    static void beforeEachMethod(String text) {
        log(() -> "    @BeforeEach " + text);
    }

    static void testMethod(String text) {
        log(() -> "      @Test " + text);
    }

    static void afterEachMethod(String text) {
        log(() -> "    @AfterEach " + text);
    }

    static void afterEachCallback(Extension extension) {
        log(() -> "  " + extension.getClass().getSimpleName() + ".afterEach()");
    }

    static void afterAllMethod(String text) {
        log(() -> "@AfterAll " + text);
    }

    private static void log(Supplier<String> supplier) {
        // System.err.println(supplier.get());
        logger.info(supplier);
    }

}
