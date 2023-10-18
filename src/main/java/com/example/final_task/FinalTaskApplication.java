package com.example.final_task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.final_task/mapper")
public class FinalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalTaskApplication.class, args);
    }

}
