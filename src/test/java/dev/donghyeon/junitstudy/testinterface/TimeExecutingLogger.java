package dev.donghyeon.junitstudy.testinterface;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutingLogger {
}
