package dev.donghyeon.junitstudy.extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebServerDemo {

    @RegisterExtension
    static WebServerExtension server = WebServerExtension.builder()
            .enableSecurity(false)
            .build();

    @Test
    void getProductList() {
        String serverUrl = server.getServerUrl();
        WebClient webClient = WebClient.create(serverUrl + "/products");
        // Use WebClient to connect to web server using serverUrl and verify response
    }

}
