# nacos 官网API（https://nacos.io/en-us/docs/quick-start.html）
分布式配置中心：高可用、环境切换、密码链接

# 注意点

1. 客户端使用配置文件中shared-dataids标签已经过期，使用shared-configs替代

2. 环境切换（profile）使用namespace完成

3. 注意单机和集群的启动命令不同： 
  >单机启动：startup.cmd -m standalone
  >多节点集群内部存储： startup.sh -p embedded
  >多节点集群mysql：startup.sh
  
4. 配置文件（application.properties）,使用翻译工具可以清楚明白。再用到密码链接的时候设计模块（Access Control Related Configurations）
中nacos.core.auth.enabled=true。


