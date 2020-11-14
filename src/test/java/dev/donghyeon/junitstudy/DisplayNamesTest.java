package dev.donghyeon.junitstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("특수한 케이스 테스트")
 class DisplayNamesTest {

    @DisplayName("커스텀")
    @Test
    void dis() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void 특수문자() {
    }

    @Test
    @DisplayName("😭")
    void 이모지() {
    }
}
