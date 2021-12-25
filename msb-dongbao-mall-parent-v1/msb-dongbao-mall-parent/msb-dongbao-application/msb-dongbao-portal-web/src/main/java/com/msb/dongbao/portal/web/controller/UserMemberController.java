package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.common.base.ResultWrapper;
import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/user-member")
public class UserMemberController {

    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/register")
    public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @PostMapping("/login")
    public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @PostMapping("/edit")
    public ResultWrapper edit(@RequestBody UmsMember umsMember) {
        return umsMemberService.edit(umsMember);
    }

    // for test
    @GetMapping("/mapper")
    @TokenCheck
    public ResultWrapper testMapper(HttpServletResponse response){
        String res = umsMemberService.mapper();
        System.out.println("in controller response: " + response);
        return ResultWrapper.builder().code(123).msg("token renewed").data(res).build();
    }

}
