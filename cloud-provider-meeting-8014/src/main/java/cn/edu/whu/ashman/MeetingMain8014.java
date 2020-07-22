package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MeetingMain8014 {
    public static void main(String[] args) {
        SpringApplication.run(MeetingMain8014.class,args);
    }
}
