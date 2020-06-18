package com.kyl.fund.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * 自定义全局操作
 */
public class MysqlInjector extends AutoSqlInjector {

    /**
     * 扩展injector方法，完成我们的自定义操作
     */
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
                       Class<?> modelClass, TableInfo table) {
        // 将EmployeeMapper中的deleteAll()方法，处理成对应的MappedStatement对象，加入到Configuration对象中。
        //首先要拿到要注入的sql预语句
        String sql="delete from "+table.getTableName();
        //要注入的方法名，这里的方法名一定要与将EmployeeMapper中定义的方法名相同
        String method="deleteAll";
        //构造sqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);
        //构造一个删除的MappedStatement
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }




}
