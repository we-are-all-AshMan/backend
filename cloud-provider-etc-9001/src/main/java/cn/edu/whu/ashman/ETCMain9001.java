package cn.edu.whu.ashman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Zhuyuhan
 * @date 2020-07-18 9:04
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ETCMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ETCMain9001.class,args);
    }
}
