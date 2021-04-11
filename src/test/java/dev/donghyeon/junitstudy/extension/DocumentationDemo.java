package dev.donghyeon.junitstudy.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.nio.file.Path;

class DocumentationDemo {

    static Path lookUpDocsDir() {
        // 문서 경로를 적는다.
        return null;
    }

    @RegisterExtension
    DocumentationExtension docs = DocumentationExtension.forPath(lookUpDocsDir());

    @Test
    void generateDocumentation() {
        // use this.docs ...
    }
}

class DocumentationExtension implements AfterEachCallback {

    private final Path path;

    private DocumentationExtension(Path path) {
        this.path = path;
    }

    static DocumentationExtension forPath(Path path) {
        return new DocumentationExtension(path);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        /* no-op for demo */
    }
}