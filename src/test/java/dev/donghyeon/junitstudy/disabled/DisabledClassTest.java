package dev.donghyeon.junitstudy.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("이슈 #103 가 해결될 때 까지 비활성화")
public class DisabledClassTest {

    @Test
    void testWillBeSkipped() {
    }
}
