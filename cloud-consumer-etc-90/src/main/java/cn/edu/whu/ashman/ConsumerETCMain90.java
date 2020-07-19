package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-18 11:05
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerETCMain90 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerETCMain90.class,args);
    }
}
