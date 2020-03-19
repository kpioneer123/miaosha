package com.kpioneer.service.model;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author xionghu
 * @date 2020/3/17 20:48
 * @desc
 */
@Data
public class UserModel {
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotNull(message = "性别不能为空")
    private Byte gender;

    @NotNull(message = "年龄不能不填写")
    @Min(value = 0,message = "年龄必须大于0岁")
    @Max(value = 150,message = "年龄必须小于150岁")
    private Integer age;

    @NotNull(message = "手机号不能为空")
    private String telphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.register_mode
     *
     * @mbg.generated Tue Mar 17 20:19:31 CST 2020
     */
    private String registerMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.third_party_id
     *
     * @mbg.generated Tue Mar 17 20:19:31 CST 2020
     */
    private String thirdPartyId;

    @NotNull(message = "密码不能为空")
    private String encrptPassword;

}