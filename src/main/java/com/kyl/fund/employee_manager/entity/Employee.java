package com.kyl.fund.employee_manager.entity;

import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *  员工对象
 * </p>
 * @author keyulai
 * @since 2020-06-16
 */
@Data
@TableName("kyl_employee")
public class Employee extends Model<Employee> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String lastName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 类型
     */
    private Integer age;
    /**
     * 使用乐观锁对version进行标注
     */
    @Version
    private Integer version;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
