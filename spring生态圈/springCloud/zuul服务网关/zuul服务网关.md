#Zuul服务网关
##学习目标
![](./image/1-1.png)

##什么是zuul
![](./image/2-1.png)

##什么是服务网关
![](./image/3-1.png)
![](./image/3-2.png)

##为什么要使用网关
![](./image/4-1.png)
![](./image/4-2.png)

##网关解决了什么问题
![](./image/5-1.png)
![](./image/5-2.png)

##常用网关解决方案
![](./image/6-1.png)
![](./image/6-2.png)
![](./image/6-3.png)
![](./image/6-4.png)
![](./image/6-5.png)
![](./image/6-6.png)
![](./image/6-7.png)


##环境搭建
![](./image/7-1.png)

##Nginx实现Api网关
![](./image/8-1.png)
![](./image/8-2.png)
![](./image/8-3.png)

##zuul实现api网关
###搭建服务网关
![](./image/9-1.png)
![](./image/9-2.png)
![](./image/9-4.png)
![](./image/9-3.png)


###配置路由规则
![](./image/9-5.png)
![](./image/9-6.png)
![](./image/9-7.png)
![](./image/9-8.png)


###路由排除
![](./image/9-9.png)
![](./image/9-10.png)

###路由前缀

**访问路径必须加上前缀**

![](./image/9-11.png)


##网关过滤器
![](./image/10-1.png)
![](./image/10-2.png)
###关键名词
![](./image/10-3.png)
###过滤器类型
![](./image/10-4.png)
###入门案例
![](./image/10-5.png)
![](./image/10-6.png)
![](./image/10-7.png)
![](./image/10-8.png)
![](./image/10-9.png)
###统一鉴权
![](./image/10-10.png)
![](./image/10-11.png)
![](./image/10-12.png)
![](./image/10-13.png)

##zuul请求的生命周期
![](./image/11-1.png)
![](./image/11-2.png)

##网关过滤器异常统一处理

###创建过滤器
![](./image/12-1.png)
![](./image/12-2.png)
![](./image/12-3.png)

###模拟异常
![](./image/12-4.png)

###配置文件
![](./image/12-5.png)
###访问


##zuul和hystrix无缝结合
![](./image/13-1.png)

###网关监控
![](./image/13-2.png)
![](./image/13-3.png)
![](./image/13-4.png)
![](./image/13-5.png)
![](./image/13-6.png)

###网关熔断
![](./image/13-7.png)
![](./image/13-8.png)
![](./image/13-9.png)
![](./image/13-10.png)
![](./image/13-11.png)

###网关限流
![](./image/13-12.png)
![](./image/13-13.png)
![](./image/13-14.png)
![](./image/13-15.png)
![](./image/13-16.png)
![](./image/13-17.png)
![](./image/13-18.png)
![](./image/13-19.png)
![](./image/13-20.png)
![](./image/13-21.png)
![](./image/13-22.png)
添加依赖
![](./image/13-23.png)

全局限流配置
![](./image/13-25.png)

局部限流配置
![](./image/13-24.png)
![](./image/13-26.png)

![](./image/13-27.png)
![](./image/13-28.png)
![](./image/13-29.png)
![](./image/13-32.png)
![](./image/13-33.png)
![](./image/13-34.png)
![](./image/13-35.png)
![](./image/13-36.png)
![](./image/13-37.png)
###网关调优
![](./image/13-38.png)
![](./image/13-39.png)
![](./image/13-40.png)
![](./image/13-41.png)

##zuul和Sentinel整合

##高可用网关