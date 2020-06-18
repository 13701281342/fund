package com.kyl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kyl.fund.employee_manager.entity.Employee;
import com.kyl.fund.employee_manager.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * 员工管理测试
 */
public class MpPageTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试分页插件
     * 打印出的sql ：Preparing: SELECT id AS id,last_name AS lastName,email,gender,age FROM kyl_employee LIMIT 0,2
     * 分析 ：sql 中带了 LIMIT子句  ，达到了分页效果
     */
    @Test
    public void testPage(){
        List<Employee> list = employeeMapper.selectPage(new Page<>(2,2),null);
        System.out.println("数据结果："+list);
    }


}
