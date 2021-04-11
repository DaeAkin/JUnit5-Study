package dev.donghyeon.junitstudy.callback;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static dev.donghyeon.junitstudy.callback.Logger.afterEachCallback;
import static dev.donghyeon.junitstudy.callback.Logger.beforeEachCallback;


public class Extension1 implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        beforeEachCallback(this);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        afterEachCallback(this);
    }
}


