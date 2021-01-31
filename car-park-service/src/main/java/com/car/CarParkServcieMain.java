package com.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mapper")
public class CarParkServcieMain {
    public static void main(String[] args) {

        SpringApplication.run(CarParkServcieMain.class, args);
    }

}
