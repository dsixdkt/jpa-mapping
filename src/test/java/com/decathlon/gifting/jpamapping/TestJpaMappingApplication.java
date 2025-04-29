package com.decathlon.gifting.jpamapping;

import org.springframework.boot.SpringApplication;

public class TestJpaMappingApplication {

    public static void main(String[] args) {
        SpringApplication.from(JpaMappingApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
