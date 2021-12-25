package com.msb.dongbao.ums.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author hb
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;
    /**
     * icon
     */
    private String icon;

    /**
     * email
     */
    private String email;

    /**
     * nickname
     */
    private String nickName;

    /**
     * comment note
     */
    private String note;

    /**
     * 0->deactived；1->activated
     */
    private Integer status;

    /**
     * created time
     */
//    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    /**
     * modified time
     */
//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String gmtModified;

    /**
     * last time of login
     */
    private Date loginTime;


}
