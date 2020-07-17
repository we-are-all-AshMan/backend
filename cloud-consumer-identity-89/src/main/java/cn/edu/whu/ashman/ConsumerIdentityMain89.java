package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-17 17:32
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerIdentityMain89 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerIdentityMain89.class,args);
    }
}
