package dev.donghyeon.junitstudy.callback;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static dev.donghyeon.junitstudy.callback.Logger.*;

/**
 * Abstract base class for tests that use the database.
 */
abstract class AbstractDatabaseTests {

    @BeforeAll
    static void createDatabase() {
        beforeAllMethod(AbstractDatabaseTests.class.getSimpleName() + ".createDatabase()");
    }

    @BeforeEach
    void connectToDatabase() {
        beforeEachMethod(AbstractDatabaseTests.class.getSimpleName() + ".connectToDatabase()");
    }

    @AfterEach
    void disconnectFromDatabase() {
        afterEachMethod(AbstractDatabaseTests.class.getSimpleName() + ".disconnectFromDatabase()");
    }

    @AfterAll
    static void destroyDatabase() {
        afterAllMethod(AbstractDatabaseTests.class.getSimpleName() + ".destroyDatabase()");
    }

}

