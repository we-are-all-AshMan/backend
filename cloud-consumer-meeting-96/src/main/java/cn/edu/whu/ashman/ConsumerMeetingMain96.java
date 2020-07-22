package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMeetingMain96 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMeetingMain96.class,args);
    }
}
