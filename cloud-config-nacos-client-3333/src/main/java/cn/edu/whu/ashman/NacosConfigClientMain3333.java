package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 20:48
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3333 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3333.class,args);
    }
}
