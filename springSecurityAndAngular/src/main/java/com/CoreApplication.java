package com;

import com.configuration.WebConfiguration;
import com.configuration.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Import({WebConfiguration.class, WebMvcConfiguration.class})
@SpringBootApplication
@EntityScan(value = {"com.entities"})
@EnableJpaRepositories(repositoryImplementationPostfix = "", basePackages = {"com.repository"})
@ComponentScan(value = {"com.service","com.controller"})
public class CoreApplication  {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }


}
