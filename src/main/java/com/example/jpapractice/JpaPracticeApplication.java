package com.example.jpapractice;

import com.example.jpapractice.dao.specs.DylanRepositoryFactoyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryFactoryBeanClass = DylanRepositoryFactoyBean.class)
@SpringBootApplication
public class JpaPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }
}
