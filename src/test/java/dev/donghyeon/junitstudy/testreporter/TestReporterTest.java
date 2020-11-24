package dev.donghyeon.junitstudy.testreporter;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

public class TestReporterTest {

    StringBuffer sbtags = new StringBuffer();
    StringBuffer displayName = new StringBuffer();
    StringBuffer className = new StringBuffer();
    StringBuffer methodName = new StringBuffer();

//    @Test
//    void reportSingleValue(TestReporter testReporter) {
//        testReporter.publishEntry("a status message");
//    }
//
//    @Test
//    void reportKeyValuePair(TestReporter testReporter) {
//        testReporter.publishEntry("a key", "a value");
//    }

    @Test
    void reportMultipleKeyValuePairs(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("user name", "dk38");
        values.put("award year", "1974");

        testReporter.publishEntry(values);

    }

    @BeforeEach
    void init(TestInfo testInfo) {
        className.delete( 0, className.length());
        className.append( testInfo.getTestClass().get().getName());
        displayName.delete( 0, displayName.length());
        displayName.append( testInfo.getDisplayName());
        methodName.delete( 0, methodName.length());
        methodName.append( testInfo.getTestMethod().get().getName());
    }

    @Test
    @DisplayName("testing on reportSingleValue")
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry( "className  : " + className);
        testReporter.publishEntry( "displayName: " + displayName);
        testReporter.publishEntry("methodName  : " + methodName);
        testReporter.publishEntry("algun mensaje de estatus");
    }

    @Test
    void reportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry( "className  : " + className);
        testReporter.publishEntry( "displayName: " + displayName);
        testReporter.publishEntry("methodName  : " + methodName);
        testReporter.publishEntry("una Key", "un Value");
    }

    @Test
    void reportMultiKeyValuePairs(TestReporter testReporter) {
        Map<String, String> map = new HashMap<>();
        map.put("Fast and Furious 8","2018");
        map.put("Matrix","1999");

        testReporter.publishEntry( "className  : " + className);
        testReporter.publishEntry( "displayName: " + displayName);
        testReporter.publishEntry("methodName  : " + methodName);
        testReporter.publishEntry(map);
    }
}

