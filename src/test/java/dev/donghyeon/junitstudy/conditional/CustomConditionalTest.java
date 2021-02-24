package dev.donghyeon.junitstudy.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

public class CustomConditionalTest {
    @Test
    @EnabledIf("eCustomCondition")
    void enabled() {


    }

    @Test
    @DisabledIf("customCondition")
    void disabled() {

    }

    boolean customCondition() {
        return true;
    }



}
class ExternalClass {

     static boolean eCustomCondition() {
        return true;
    }
}


