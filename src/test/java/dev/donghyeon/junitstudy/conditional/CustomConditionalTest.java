package dev.donghyeon.junitstudy.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionalTest {
    @Test
    @EnabledIf("customCondition")
    void enabled() {


    }

    @Test
    @DisabledIf("customCondition")
    void disabled() {

    }

    boolean customCondition() {
        return true;
    }

    @Test
    @EnabledIf("outsideMethod")
    void enabledByOutsideMethod() {

    }
}

class OutsideClass {

    boolean outsideMethod() {
        return true;
    }
}
