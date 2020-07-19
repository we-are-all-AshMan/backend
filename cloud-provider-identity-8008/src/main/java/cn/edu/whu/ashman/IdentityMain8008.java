package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-17 15:57
 */
@EnableDiscoveryClient
@SpringBootApplication
public class IdentityMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(IdentityMain8008.class,args);
    }
}
