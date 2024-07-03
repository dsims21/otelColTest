package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

@SpringBootApplication
public class DemoApplication {

    private static final Tracer tracer = GlobalOpenTelemetry.getTracer("com.example.DemoApplication");

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
        // Example of manual instrumentation
        Span span = tracer.spanBuilder("example-span").startSpan();
        span.setAttribute("example-attribute", "example-value");
        span.end();
    }
}
