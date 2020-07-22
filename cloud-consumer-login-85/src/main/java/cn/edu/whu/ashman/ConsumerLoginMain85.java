package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 19:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerLoginMain85 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerLoginMain85.class,args);
    }
}
