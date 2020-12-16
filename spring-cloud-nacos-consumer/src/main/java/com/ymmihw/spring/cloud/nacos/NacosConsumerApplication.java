package com.ymmihw.spring.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(NacosConsumerApplication.class, args);
  }

  @RestController
  @RequiredArgsConstructor
  public class TestController {

    private final RestTemplate httpRestTemplate;
    private final RestTemplate httpsRestTemplate;

    @RequestMapping(value = "/http/{str}", method = RequestMethod.GET)
    public String http(@PathVariable String str) {
      return httpRestTemplate.getForObject("http://service-provider/config/get", String.class);
    }

    @RequestMapping(value = "/https/{str}", method = RequestMethod.GET)
    public String https(@PathVariable String str) {
      return httpsRestTemplate.getForObject("https://service-provider-https/config/get",
          String.class);
    }
  }
}
