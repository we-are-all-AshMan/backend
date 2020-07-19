package cn.edu.whu.ashman.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 20:58
 * 测试读取中央配置文件的controller
 */
@RestController
@RefreshScope//支持动态刷新功能
public class ConfigController {
    @Value("${config.info}")
    private String config;

    @GetMapping("/")
    public String getConfig(){
        return config;
    }
}
