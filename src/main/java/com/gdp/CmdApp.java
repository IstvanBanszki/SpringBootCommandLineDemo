package com.gdp;

import com.gdp.model.ContentFormat;
import com.gdp.model.Organization;
import com.gdp.service.GdpProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = "com.gdp")
@SpringBootApplication
public class CmdApp implements CommandLineRunner {

    @Autowired
    private GdpProcessor processor;
    
    @Override
    public void run(String... args) {
        this.processor.getCountries(Organization.IMF, ContentFormat.JSON);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CmdApp.class, args);
    }
    
    @Bean
    @Primary
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
