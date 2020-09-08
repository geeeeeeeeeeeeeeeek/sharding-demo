package com.nemo.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.nemo"},exclude = {DataSourceAutoConfiguration.class} )
@MapperScan(value = "com.nemo.sharding.dao")
@EnableTransactionManagement
public class ShardingApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShardingApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }
}
