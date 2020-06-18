package com.kyl;

import com.kyl.fund.employee_manager.entity.Employee;
import com.kyl.fund.employee_manager.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 员工管理测试
 */
public class MpDeleteTest {

    private ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 通用新增 employeeMapper.insert(employee)
     */
    @Test
    public void testCommonInsert(){
        Employee employee = new Employee();
        employee.setLastName("99999");
        employee.setEmail("jone@qq.com");
        employee.setAge(40);
        employee.setGender(1);
        int i = employeeMapper.insert(employee);
        System.out.println("执行条数："+i);
    }

    /**
     * 使用AR模式新增 employee.insert()
     */
    @Test
    public void testCommonInsertAR(){
        Employee employee = new Employee();
        employee.setLastName("admin");
        employee.setEmail("lucy@qq.com");
        employee.setAge(36);
        employee.setGender(0);
        boolean result = employee.insert();
        System.out.println("执行结果："+result);
    }




}
