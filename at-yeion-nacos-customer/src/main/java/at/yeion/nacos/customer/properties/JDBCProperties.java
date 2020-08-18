package at.yeion.nacos.customer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: rhb
 * @Date: 2020/8/14 20:44
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "jdbc")
public class JDBCProperties {
    private String url;
    private String userName;
    private String password;
    private String driverClassName;

    private int maxActive;
    private int minIdle;
    private int initialSize;
    private boolean testWhileIdle;
    private long timeBetweenEvictionRunsMillis;
    private String validationQuery;
}
