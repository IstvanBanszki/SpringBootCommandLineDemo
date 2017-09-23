package com.gdp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmdApp implements CommandLineRunner {

    @Override
    public void run(String... args) {
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CmdApp.class, args);
    }
}
