package dev.donghyeon.junitstudy.extension;


import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebServerExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        /* no-op for demo */
        System.out.println("WebServerExtension call");
    }

    public String getServerUrl() {
        return "https://example.org:8181";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public Builder enableSecurity(boolean b) {
            return this;
        }

        public WebServerExtension build() {
            return new WebServerExtension();
        }

    }

}

