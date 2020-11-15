package dev.donghyeon.junitstudy.assumption;

import dev.donghyeon.junitstudy.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumptionTest {
    private final Calculator calculator = new Calculator();

    @Test
    void CI서버에서만_테스트() {
        assumeTrue("CI".equals(System.getenv("ENV")));
    }

    @Test
    void 개발환경에서만_테스트() {
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    void 모든환경_테스트() {
        assumingThat("CI".equals(System.getenv("ENV")), () -> {
            // CI 서버에서만 실행하는 테스트
            assertEquals(2, calculator.divide(4, 2));
        });
        // 모든 환경에서 실행하는 테스트
        assertEquals(42, calculator.multiply(6, 7));
    }
}
