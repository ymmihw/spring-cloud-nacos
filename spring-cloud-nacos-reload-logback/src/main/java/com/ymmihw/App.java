package com.ymmihw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class App {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(App.class, args);
        for (; ; ) {
            TimeUnit.SECONDS.sleep(1);
            log.info("info");
            log.error("error");
        }
    }
}
