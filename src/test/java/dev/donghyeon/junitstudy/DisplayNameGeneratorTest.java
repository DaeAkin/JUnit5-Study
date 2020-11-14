package dev.donghyeon.junitstudy;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DisplayNameGeneratorTest {
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class X_년은_지원되지않음 {

        @Test
        void zero_일경우() {
        }

        @DisplayName("윤년 계산할 때 음수 값은 지원되지 않음.")
        @ParameterizedTest(name = "예를 들어, {0} 년은 지원되지 않음.")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class X년은_윤년이다 {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "{0} 년은 윤년이다.")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {
        }

    }
}
