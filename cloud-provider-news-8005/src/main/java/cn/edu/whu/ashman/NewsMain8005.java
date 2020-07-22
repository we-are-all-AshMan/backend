package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 15:47
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NewsMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(NewsMain8005.class,args);
    }
}
