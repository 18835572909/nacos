package at.yeion.nacos.customer.controller;

import at.yeion.nacos.customer.model.ResultResponse;
import at.yeion.nacos.customer.properties.JDBCProperties;
import at.yeion.nacos.customer.properties.RabbitMQProperties;
import at.yeion.nacos.customer.service.DemoFeignService;
import at.yeion.nacos.customer.service.DemoRibbonService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: rhb
 * @Date: 2020/8/14 19:01
 * @Description: Nacos测试
 */
@RefreshScope
@RestController
@RequestMapping("/test")
@Api("Nacos测试")
public class DemoController {

    @Autowired
    DemoRibbonService ribbonService;

    @Autowired
    DemoFeignService feignService;

    @Autowired
    RabbitMQProperties mqProperties;

    @Autowired
    JDBCProperties jdbcProperties;

    @ApiOperation(value = "Ribbon通讯测试",code = 200)
    @RequestMapping(value="/ribbon/ping",method = RequestMethod.GET)
    public ResultResponse ping1() {
        return ResultResponse.newInstance(ribbonService.ping());
    }

    @ApiOperation(value = "Feign通讯测试",code = 200)
    @RequestMapping(value="/feign/ping",method = RequestMethod.GET)
    public ResultResponse ping2() throws Exception {
        return ResultResponse.newInstance(feignService.ping());
    }

    @ApiOperation(value = "Config测试",code = 200)
    @ApiImplicitParams(@ApiImplicitParam(name = "tag",value = "tag取0|1测试",dataType = "int",paramType = "formData"))
    @RequestMapping(value="/properties",method = RequestMethod.GET)
    public ResultResponse properties(@RequestParam(defaultValue = "1") int tag){
        if(tag == 0) return ResultResponse.newInstance(mqProperties);
        else return ResultResponse.newInstance(jdbcProperties);
    }

}
