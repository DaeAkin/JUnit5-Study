package dev.donghyeon.junitstudy.extension;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

//@Test, @BeforeEach, @AfterEach @BeforeAll and @AfterAll 에 사용될 핸들러 등록
@ExtendWith(ThirdExecutedHandler.class)
class MultipleHandlersTestCase {

    // @Test, @BeforeEach, @AfterEach 에만 사용할 핸들러를 등록.
    @ExtendWith(SecondExecutedHandler.class)
    @ExtendWith(FirstExecutedHandler.class)
    @Test
    void testMethod() {
        throw new RuntimeException("예외를 던지면 FirstExecutedHandler가 실행된다.");
    }


    static class FirstExecutedHandler implements TestExecutionExceptionHandler {
        @Override
        public void handleTestExecutionException(ExtensionContext context, Throwable ex)
                throws Throwable {
            System.out.println("FirstExecutedHandler");
            throw ex;
        }
    }

    static class SecondExecutedHandler implements LifecycleMethodExecutionExceptionHandler {
        @Override
        public void handleBeforeEachMethodExecutionException(ExtensionContext context, Throwable ex)
                throws Throwable {
            System.out.println("SecondExecutedHandler");
            throw ex;
        }
    }
}

class ThirdExecutedHandler implements LifecycleMethodExecutionExceptionHandler {
    @Override
    public void handleBeforeAllMethodExecutionException(ExtensionContext context, Throwable ex)
            throws Throwable {
        System.out.println("ThirdExecutedHandler");
        throw ex;
    }
}
