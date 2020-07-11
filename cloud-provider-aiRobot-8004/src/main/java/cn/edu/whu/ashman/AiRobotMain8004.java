package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AiRobotMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(AiRobotMain8004.class,args);
    }
}