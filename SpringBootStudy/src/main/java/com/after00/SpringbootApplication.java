package com.after00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

//手动禁止链接数据库@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling //启动定时任务
@Slf4j
public class SpringbootApplication {
    /**
     * 启动方式1：直接main；
     * 启动方式2：cd到项目路径；执行mvn spring-boot:run
     * 启动方式3：cd到项目路径，编译mvn install；target目录生成jar文件；java -jar 启动生成的jar。
     * @param args
     */
    public static void main(String[] args) {
        log.info("dataService is starting...");
        SpringApplication.run(SpringbootApplication.class);
        log.info("dataService starting success");
    }
}
