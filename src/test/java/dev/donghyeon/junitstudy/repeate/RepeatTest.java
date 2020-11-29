package dev.donghyeon.junitstudy.repeate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatTest {
    @RepeatedTest(10)
    void repeatedTest() {
    }

    @RepeatedTest(10)
    void repeatedTest_with_info(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
    }
}
