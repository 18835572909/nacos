package at.yeion.nacos.customer.properties;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: rhb
 * @Date: 2020/8/14 20:48
 * @Description:
 *
######rabbitmq消息队列设置#######
#rabbitmq服务器IP
rabbitmq.host=39.103.132.51
#rabbitmq的端口号
rabbitmq.port=5672
#rabbitmq访问用户名
rabbitmq.username=admin
#rabbitmq访问密码
rabbitmq.password=admin
#命名空间（虚拟主机）,默认/
rabbitmq.virtualHost=/
#发布确认，保证消息被正确投递
rabbitmq.publisherConfirms=true
#发布事物，失败可以重发
rabbitmq.publisherReturns=true
#当mandatory参数设为true时，交换器无法根据自身的类型和路由键找到一个符合条件的队列，那么RabbitMQ会调用Basic.Return命令将消息返回给生产者。当mandatory参数设置为false时，则消息直接被丢弃。
rabbitmq.template.mandatory=true
 */
@Data
@Component
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {
    private String host;
    private String port;
    private String username;
    private String password;
    private String virtualHost;
    private String publisherConfirms;
    private String templateMandatory;
}
