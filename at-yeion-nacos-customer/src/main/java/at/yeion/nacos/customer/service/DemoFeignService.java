package at.yeion.nacos.customer.service;

import at.yeion.nacos.customer.service.impl.DemoFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: rhb
 * @Date: 2020/8/14 19:23
 * @Description:
 */
@FeignClient(value = "nacos-demo-producer",fallback = DemoFeignServiceFallBack.class)
public interface DemoFeignService {

    @RequestMapping(value = "/demo/ping",method = RequestMethod.GET)
    String ping() throws Exception;
}
