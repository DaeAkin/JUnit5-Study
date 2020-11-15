package dev.donghyeon.junitstudy.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {
    @Disabled("#42 버그가 해결될 때 까지 비활성화")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}
