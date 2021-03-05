package com.example.hello;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


@RestController
public class RandomNumberController {



    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();



    @RequestMapping("/randomNumber")
    public Greeting randomNumber(@RequestParam(value="value", defaultValue= "100") String number) {

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, number));
    }
}
