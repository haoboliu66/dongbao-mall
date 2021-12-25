package com.msb.dongbao.ums.service.impl;

import com.msb.dongbao.common.base.ResultWrapper;
import com.msb.dongbao.common.base.StateCodeEnum;
import com.msb.dongbao.common.util.JWTUtils;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.entity.response.UmsMemberLoginResponse;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author hb
 * @since 2021-04-05
 */

@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {

        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        String password = umsMemberRegisterParamDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        umsMember.setPassword(encodedPassword);

        umsMemberMapper.insert(umsMember);
        umsMember.setPassword("");
        return ResultWrapper.getSucessBuilder().data(umsMember).build();
    }

    @Override
    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (umsMember == null) {
            return ResultWrapper.builder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.USER_EMPTY.getMsg()).build();
        }
        if (!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(), umsMember.getPassword())) {
            return ResultWrapper.builder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.PASSWORD_ERROR.getMsg()).build();
        }
        // create token for the use
        String token = JWTUtils.createToken(umsMember.getUsername());

        UmsMemberLoginResponse umsMemberLoginResponse = new UmsMemberLoginResponse();
        umsMember.setPassword("");
        umsMemberLoginResponse.setUmsMember(umsMember);
        umsMemberLoginResponse.setToken(token);

        return ResultWrapper.getSucessBuilder().data(umsMemberLoginResponse).build();
    }

    @Override
    public ResultWrapper edit(UmsMember umsMember) {
        UmsMember searchedResult = umsMemberMapper.selectByName(umsMember.getUsername());
        if (searchedResult == null) {
            return ResultWrapper.builder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.USER_EMPTY.getMsg()).build();
        }
        BeanUtils.copyProperties(umsMember, searchedResult);
        return ResultWrapper.getSucessBuilder().data(searchedResult).build();
    }

    public boolean validateToken(String token, UmsMember umsMember) {
        String username = JWTUtils.parseToken(token);
        return false;
    }

    @Override
    public String mapper() {
        return umsMemberMapper.selectInteger();
    }


}
