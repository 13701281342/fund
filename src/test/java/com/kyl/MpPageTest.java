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
 * 分页插件测试
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
        Page<Employee> page = new Page<>(1,2);
        List<Employee> list = employeeMapper.selectPage(page,null);
        System.out.println("数据结果："+list);
        System.out.println("---------------------获取分页相关的信息=====================");
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("总页数："+page.getPages());
        System.out.println("每页显示条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    /**
     * 测试SQL执行分析插件，用来分析Delete 和 update 操作是否是对全表的操作
     */
    @Test
    public void testSQLExplain(){
        int count = employeeMapper.delete(null); //删除全部数据，虽然不会报错，但是数据不会被删除
        System.out.println("执行条数："+count);
    }

    /**
     * 性能分析插件，用来分析Sql的执行时间，可以设置sql的执行时间阈值，从而分析sql执行的问题
     */
    @Test
    public void testSqlPerformance(){
        Employee employee = new Employee();
        employee.setLastName("keyulai");
        employee.setEmail("keyulai@sina.com");
        employee.setGender(1);
        employee.setAge(20);
        int count = employeeMapper.insert(employee);
        System.out.println("执行条数："+count);
    }

    /**
     * 测试乐观锁OptimisticLockerInterceptor
     * 当前获取的版本与数据库中存的版本不一致，则不会执行操作
     */
    @Test
    public void testOptimisticLocker(){
        Employee employee = new Employee();
        employee.setId(15);
        employee.setLastName("tomcat");
        employee.setEmail("tomcat@sina.com");
        employee.setVersion(2);
        int count = employeeMapper.updateById(employee);
        System.out.println("执行条数："+count);
    }
}
