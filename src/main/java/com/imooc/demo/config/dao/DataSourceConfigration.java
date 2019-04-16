package com.imooc.demo.config.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

//连接数据库
//配置datasource到ioc容器里面

//告诉spring容器，需要到这个类下进行检索相关的bean，spring初始化时就会去调用这个bean方法
@Configuration

//Dao层通过mybatis实现
//配置mybatis mapper的扫描路径
@MapperScan("com.imooc.demo.dao") //扫描一会儿创建的package
public class DataSourceConfigration {
    //对变量进行赋值，或统一到application.properties
    @Value("${jdbc.driver}")    //对变量进行引入
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserbame;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")  //dataSource表示bean的id
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {    //返回数据库连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserbame);
        dataSource.setPassword(jdbcPassword);

        dataSource.setMaxPoolSize(30);
        dataSource.setMinPoolSize(10);
        dataSource.setAutoCommitOnClose(false);
        dataSource.setCheckoutTimeout(10000);
        dataSource.setAcquireRetryAttempts(2);
        return dataSource;
    }
}
