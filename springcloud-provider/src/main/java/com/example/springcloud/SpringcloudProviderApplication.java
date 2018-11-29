package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient //服务发现
@EnableHystrix
public class SpringcloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudProviderApplication.class, args);
	}
}
