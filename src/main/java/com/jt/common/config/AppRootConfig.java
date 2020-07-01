package com.jt.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource("classpath:configs.properties")
@ComponentScan(value = "com.jt", excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})})
@MapperScan(basePackages = "com.jt.**.dao")
public class AppRootConfig {
    @Bean(value = "dataSource", initMethod = "init", destroyMethod = "close")  //==<bean id="" ...>
    public DruidDataSource newDruidDataSource(
            @Value("${jdbcDriver}") String driver, @Value("${jdbcUrl}") String url,
            @Value("${jdbcUser}") String user, @Value("${jdbcPassword}") String password) {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        return ds;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean newSqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException {
        SqlSessionFactoryBean fBean = new SqlSessionFactoryBean();
        //关联数据源对象
        fBean.setDataSource(dataSource);
        //关联mapper映射文件
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml");
        fBean.setMapperLocations(mapperLocations);
        return fBean;
    }
}
