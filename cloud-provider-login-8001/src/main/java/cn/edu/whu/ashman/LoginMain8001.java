package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-09 0:06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LoginMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(LoginMain8001.class,args);
    }
}
