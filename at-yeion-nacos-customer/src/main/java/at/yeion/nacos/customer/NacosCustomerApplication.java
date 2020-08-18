package at.yeion.nacos.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: rhb
 * @Date: 2020/8/14 18:52
 * @Description:
 */

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NacosCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosCustomerApplication.class);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
