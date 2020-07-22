package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 10:37
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerFinalAppointmentMain94 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFinalAppointmentMain94.class,args);
    }
}
