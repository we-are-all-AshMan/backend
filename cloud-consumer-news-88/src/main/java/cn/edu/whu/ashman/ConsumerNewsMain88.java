package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 23:57
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerNewsMain88 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNewsMain88.class,args);
    }
}
