package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 10:26
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PolicyMain8012 {
    public static void main(String[] args) {
        SpringApplication.run(PolicyMain8012.class,args);
    }
}
