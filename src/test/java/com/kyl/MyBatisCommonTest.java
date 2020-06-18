package com.kyl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

public class MyBatisCommonTest {

    private ApplicationContext context
            = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 测试数据源和连接
     */
    @Test
    public void testDataSource() throws Exception{
        DataSource dataSource =context.getBean("dataSource",DataSource.class);
        System.out.println("获取到数据源dataSource="+dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println("获取连接："+connection);
    }

}
