package at.yeion.nacos.customer.service.impl;

import at.yeion.nacos.customer.service.DemoRibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: rhb
 * @Date: 2020/8/14 18:56
 * @Description:
 */

@Service
public class DemoRibbonServiceImpl implements DemoRibbonService {

    private static final String PRODUCER_SERVICE_PREFIX = "http://nacos-demo-producer/";

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(groupKey = "nacos-demo-producer",fallbackMethod = "pingFallback")
    public String ping() {
        ResponseEntity<String> repEntity = restTemplate.getForEntity("http://nacos-demo-producer/demo/ping", String.class);
        if(repEntity.getStatusCode()== HttpStatus.OK){
            return repEntity.getBody();
        }
        return "nil";
    }

    public String pingFallback(){
        return "系统错误，稍后重试";
    }
}
