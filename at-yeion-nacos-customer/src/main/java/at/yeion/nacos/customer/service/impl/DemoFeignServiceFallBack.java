package at.yeion.nacos.customer.service.impl;

import at.yeion.nacos.customer.service.DemoFeignService;

/**
 * @Author: rhb
 * @Date: 2020/8/14 19:31
 * @Description:
 */
public class DemoFeignServiceFallBack implements DemoFeignService {

    @Override
    public String ping() throws Exception {
        throw new Exception("nacos-demo-producer 服务调用失败");
    }
}
