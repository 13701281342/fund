package com.kyl;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;


public class CodeGenerate {

    /**
     * 测试代码生成
     */
    @Test
    public void CodeGenerateTest(){

        /**1、全局配置**/
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)  //是否支持AR模式
        .setAuthor("keyulai")
                .setOutputDir("D:\\pinming\\kylmybatisPlus\\src\\main\\java")  //代码生成路径
                .setFileOverride(true)     //多次生成code时，是否覆盖上次生成的code
                .setIdType(IdType.AUTO)     //主键自增策略
                .setServiceName("%sService")   //生成service的名字前面是否为IService
                .setBaseResultMap(true)    //生成基本的baseResultMap
                .setBaseColumnList(true);  //设置基本的sql片段

        /**2.数据源配置**/
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL) //设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/pinming?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT")
                .setUsername("keyulai")
                .setPassword("keyulai");

        /**3.策略配置**/
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)   //开启全局大小写命令
                .setDbColumnUnderline(true)  //表字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) //数据库表映射到实体类的命名策略（下换线转驼峰）
                .setTablePrefix("kyl_")  //表前缀
                .setInclude("kyl_employee");  //生成的表

        /**4.包名策略配置**/
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.kyl.fund")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setModuleName("employee_manager")
                .setXml("mapper");

        /**5.整合配置**/
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        /**6.执行**/
        ag.execute();
    }



}