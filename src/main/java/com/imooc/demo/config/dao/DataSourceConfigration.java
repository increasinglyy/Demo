package com.imooc.demo.config.dao;

import org.springframework.context.annotation.Bean;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

//连接数据库
public class DataSourceConfigration {
    //对变量进行赋值，或统一到application.properties
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUserbame;
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
