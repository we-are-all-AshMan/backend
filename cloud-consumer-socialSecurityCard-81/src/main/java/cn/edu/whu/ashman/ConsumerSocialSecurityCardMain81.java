package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 11:24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerSocialSecurityCardMain81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSocialSecurityCardMain81.class, args);
    }
}
