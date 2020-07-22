package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 11:15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SocialSecurityCardMain8010 {
    public static void main(String[] args) {
        SpringApplication.run(SocialSecurityCardMain8010.class, args);
    }
}
