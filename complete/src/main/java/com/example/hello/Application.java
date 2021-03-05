package com.example.hello;

import static com.github.tomakehurst.wiremock.client.WireMock.aMultipart;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToXml;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingXPath;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        WireMockServer wm = new WireMockServer(options().port(2345));
        wm.start();

        wm.stubFor(any(urlPathEqualTo("/MyHeader"))

            .willReturn(ResponseDefinitionBuilder.like(new ResponseDefinitionBuilder()
                .withHeader("MyHeader", "Transformed")
                .withStatus(200)
                .withBody("Transformed a nice body")
                .build())));


        SpringApplication.run(com.example.hello.Application.class, args);

    }

}
