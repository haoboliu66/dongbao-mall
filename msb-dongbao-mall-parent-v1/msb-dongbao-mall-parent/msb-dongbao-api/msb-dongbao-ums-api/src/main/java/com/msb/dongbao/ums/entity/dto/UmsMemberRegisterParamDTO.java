package com.msb.dongbao.ums.entity.dto;

// Data Transfer Object - receive params

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UmsMemberRegisterParamDTO {

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Size(min = 9, message = "Password length must not be less than 9")
    private String password;

    @Email(message = "Invalid Email")
    private String email;

    private String icon;

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
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreated;

    /**
     * modified time
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String gmtModified;

}
