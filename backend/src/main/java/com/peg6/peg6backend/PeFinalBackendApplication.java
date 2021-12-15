package com.peg6.peg6backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.peg6.peg6backend.mapper")
public class PeFinalBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeFinalBackendApplication.class, args);
    }

}
