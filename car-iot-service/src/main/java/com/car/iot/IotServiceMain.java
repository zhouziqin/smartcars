package com.car.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mapper")
@EnableSwagger2
public class IotServiceMain {
    public static void main(String[] args) {

        SpringApplication.run(IotServiceMain.class, args);
    }

}
