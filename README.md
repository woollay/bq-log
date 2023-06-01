# bq-log组件的使用说明
- 本组件基于springBoot二次封装，主要是为了简化和固化常规的业务场景，当然也支持灵活的配置扩展：
- 本组件引入方法：
    ```xml
    <dependency>
        <groupId>com.biuqu</groupId>
        <artifactId>bq-log</artifactId>
        <version>1.0.2</version>
    </dependency>
    ```

## 1. 为什么要写bq-log组件

- 日志是业务安全的凭证，需要记录的日志包括服务运行日志、业务操作日志、安全日志等；
- 日志支持的业务场景也较多，比如接口计费、错误码统计等等，可以和大数据等平台对接，需要较好地扩展性；
- 本日志组件仅实现了一个写文件的包含上述几种业务场景的封装实现，有兴趣的朋友可以在此基础上做更高阶的扩展实现；

## 2. bq-log最佳实践
- bq-log最佳实践是配合springboot一起使用，bq-log中的能力在[bq-boot-root](https://github.com/woollay/bq-boot-root) 和[bq-boot-base](https://github.com/woollay/bq-boot-base) 
中有更好的体现；


