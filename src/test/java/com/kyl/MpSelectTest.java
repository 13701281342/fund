package com.kyl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.kyl.fund.employee_manager.entity.Employee;
import com.kyl.fund.employee_manager.mapper.EmployeeMapper;
import com.mchange.v2.collection.MapEntry;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * 员工管理测试
 */
public class MpSelectTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试 List<T> selectList(@Param("ew") Wrapper<T> wrapper); 接口
     */
    @Test
    public void testSelectList(){
        List<Employee> list = employeeMapper.selectList(null);
        System.out.println("数据结果："+list);
    }

    /**
     *  根据 entity 条件，查询全部记录
     */
    @Test
    public void testSelectListByParams(){
        EntityWrapper<Employee> wrapper = new EntityWrapper<>();
        wrapper.eq("last_name","Tom");
        List<Employee> list = employeeMapper.selectList(wrapper);
        System.out.println("数据结果："+ list);
    }

    /**
     * 根据注解id查询对象
     */
    @Test
    public void testSelectById(){
        Employee employee = employeeMapper.selectById(10);
        System.out.println("数据结果："+employee);
    }

    /**
     * 根据多个ids查询（根据ID 批量查询） selectBatchIds
     */
    @Test
    public void testSelectByIdList(){
        List<Integer> idList = Arrays.asList(8,9,10);
        List<Employee> list = employeeMapper.selectBatchIds(idList);
        System.out.println("数据结果："+list);
    }

    /**
     * 查询条件为map（根据 columnMap 条件）
     */
    @Test
    public void testSelectByMapParams(){
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("last_name","Tom"); //key 为数据库中的字段
        columnMap.put("age",30);
        List<Employee> list = employeeMapper.selectByMap(columnMap);
        System.out.println("数据结果："+list);
    }

    /**
     * 查询单个对象
     */
    @Test
    public void testSelectOne(){
        Employee emp = new Employee();
        emp.setLastName("Tom");
        Employee employee = employeeMapper.selectOne(emp);
        System.out.println("数据结果："+employee);
    }

    /**
     * 查询总记录数
     */
    @Test
    public void testSelectCount(){
        EntityWrapper<Employee> wrapper = new EntityWrapper<>();
        Integer count = employeeMapper.selectCount(wrapper);
        System.out.println("数据总条数："+ count);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * List<Map<String, Object>> selectMaps(@Param("ew") Wrapper<T> wrapper);
     */
    @Test
    public void testSelectMaps(){
        EntityWrapper<Employee> wrapper = new EntityWrapper<>();
        List<Map<String, Employee>> list = (List)employeeMapper.selectMaps(wrapper);
        List<Employee> empList = new ArrayList<>();
        //遍历list获取每个map对象
     /*   for (Map<String, Employee> map : list){
            //获取map的values(即Employee) 放入到新的集合中
            empList.addAll(map.values());    //获取的是Employee对象中的所有属性值，放入Employee对象中
            System.out.println("key="+map.keySet()); //获取的是Employee对象中的所有属性
        }
        */
        for (Map<String, Employee> map : list){
            for (Map.Entry<String,Employee> entry : map.entrySet()){
                System.out.println(entry.getKey()+"="+entry.getValue()+"\n");
            }
        }
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * 注意： 只返回第一个字段的值
     * </p>
     * @param wrapper 实体对象封装操作类（可以为 null）
     * List<Object> selectObjs(@Param("ew") Wrapper<T> wrapper);
     * @return List<Object>
     */

    @Test
    public void testSelectObjs(){
        EntityWrapper<Employee> wrapper = new EntityWrapper<>();
        //这个方法可以用来获取数据主键id列表
        List<Object> list = employeeMapper.selectObjs(wrapper);
        for (Object id : list){
            System.out.println("返回第一个字段的值id："+id);
        }
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）这里的分页是内存分页，
     * 查询sql中 （SELECT id AS id,last_name AS lastName,email,gender,age FROM kyl_employee ）并没有带分页,
     * </p>
     * @param rowBounds 分页查询条件（可以为 RowBounds.DEFAULT）
     * @param wrapper   实体对象封装操作类（可以为 null）
     * List<T> selectPage(RowBounds rowBounds, @Param("ew") Wrapper<T> wrapper);
     * @return List<T>
     */
    @Test
    public void testSelectPage(){
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1,3),null);
        System.out.println("员工列表："+list);
    }


    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     * </p>
     * @param rowBounds 分页查询条件（可以为 RowBounds.DEFAULT）
     * @param wrapper   实体对象封装操作类
     * @return List<Map<String, Object>>
     */
    @Test
    public void testSelectMapsPage(){
        List<Map<String, Object>> list = employeeMapper.selectMapsPage(new Page<Employee>(1,3),null);
        System.out.println(list);
    }

    /******************************** AR 模式查询（领域模型对象）***ActiveRecord 模式 CRUD ，主要使用的是Model 这个对象****************************************************/

    /**
     * 查询所有   employee.selectAll()
     */
    @Test
    public void testAR_selectAll(){
        Employee employee = new Employee();
        List<Employee > emps = employee.selectAll();
        System.out.println(emps);
    }








    /**
     * 使用AR 模式查询必须要满足当前entity 必须要继承 Model<Entity>
     * AR 模式根据主键id 查询该对象  employee.selectById()
     */
    @Test
    public void testAR_SelectById(){
        Employee employee = new Employee();
       /* employee.setId(10); //必须要设置主键的值
        Employee emp = employee.selectById();*/
        //或者
        Employee emp = employee.selectById(10);
        System.out.println(emp);
    }


    /**
     * 查询列表  List<T> selectList(Wrapper wrapper)
     * 参数 EntityWrapper<Employee> 对象
     */
    @Test
    public void testAR_selectList(){
        Employee employee = new Employee();
        EntityWrapper<Employee> wrapper = new EntityWrapper<>();
        wrapper.eq("last_name","Tom"); //可以传入条件，查询与条件匹配的数据
        //List<Employee> list = employee.selectList(null); //也可以传入null,则会查询所有
        List<Employee> list = employee.selectList(wrapper);
        System.out.println("查询结果："+list);
    }

    @Test
    public void testAR_selectOne(){
        Employee employee = new Employee();
        Employee emp = employee.selectOne(new EntityWrapper().like("last_name","Tom"));
        System.out.println("查询结果："+emp);
    }


    /**
     * 分页查询
     *   public Page<T> selectPage(Page<T> page, Wrapper<T> wrapper)
     */

    @Test
    public void testAR_selectPage(){
        Employee employee = new Employee();
/*        Page<Employee> page = new Page<>(1,3);
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("last_name","Tom");
        Page<Employee> pageList = employee.selectPage(page,wrapper);*/
//       Page<Employee> pageList = employee.selectPage(new Page<>(1,3),new EntityWrapper<Employee>().like("last_name","999"));
       Page<Employee> pageList = employee.selectPage(new Page<>(1,3),null);
        List<Employee> empList = pageList.getRecords();
        System.out.println("查询结果："+empList);
    }


}
