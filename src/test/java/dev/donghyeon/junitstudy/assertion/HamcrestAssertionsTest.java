package dev.donghyeon.junitstudy.assertion;

import dev.donghyeon.junitstudy.Calculator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestAssertionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    void HamcrestMatcher_이용하기() {
        assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }
}
