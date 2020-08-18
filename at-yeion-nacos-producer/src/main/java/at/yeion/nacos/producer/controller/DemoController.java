package at.yeion.nacos.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rhb
 * @Date: 2020/8/11 20:20
 * @Description: 测试配置中心
 */
@RefreshScope
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${ping}")
    private String ping;

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping("/readConf")
    public String readConf(){
        return ping;
    }
}
