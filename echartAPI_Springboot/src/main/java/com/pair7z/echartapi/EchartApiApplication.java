package com.pair7z.echartapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//@SpringBootApplication
//public class EchartApiApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(EchartApiApplication.class, args);
//    }
//
//}

//@SpringBootApplication()
//public class EchartApiApplication extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(EchartApiApplication.class, args);
//    }
//
//    // 按照下面的方式重写
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(EchartApiApplication.class);
//    }
//
//}


@SpringBootApplication
public class EchartApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(EchartApiApplication.class, args);
    }
}

