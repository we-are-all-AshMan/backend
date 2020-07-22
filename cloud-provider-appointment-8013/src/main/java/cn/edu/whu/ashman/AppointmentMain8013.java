package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:35
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AppointmentMain8013 {
    public static void main(String[] args) {
        SpringApplication.run(AppointmentMain8013.class,args);
    }
}
