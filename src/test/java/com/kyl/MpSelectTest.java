package com.kyl;

import com.kyl.fund.employee_manager.entity.Employee;
import com.kyl.fund.employee_manager.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 员工管理测试
 */
public class MpSelectTest {

    private ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试 List<T> selectList(@Param("ew") Wrapper<T> wrapper); 接口
     */
    @Test
    public void testSelectList(){
        List<Employee> emps = employeeMapper.selectList(null);
        System.out.println("执行条数："+emps);
    }


}
