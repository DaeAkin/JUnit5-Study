package dev.donghyeon.junitstudy.dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.springframework.test.util.AssertionErrors.assertEquals;

class DynamicUriTest {

    @TestFactory
    void classPathTest() throws Throwable {
        DynamicTest classPathTest = dynamicTest("classPathTest"
                , new URI("classpath:/test/resources/two-column.csv")
                , () -> System.out.println("??"));
    }

    @TestFactory
    Stream<DynamicTest> checkAllTextFiles() throws Exception {
        return Files.walk(Paths.get("src/test/resources/jump"), 1)
                .filter(path -> path.toString().endsWith(".txt"))
                .map(path -> dynamicTest(
                        "> " + path.getFileName(),
                        path.toUri(), // test source uri
                        () -> checkLines(path)));
    }

    private void checkLines(Path path) throws Exception {
        var lines = Files.readAllLines(path);
        var expected = lines.get(1);
        var actual = new StringBuilder(lines.get(0)).reverse().toString();
        assertEquals("Second line is not the reversed first!",expected, actual );
    }

}
