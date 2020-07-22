package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 21:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerPolicyMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerPolicyMain83.class,args);
    }
}
