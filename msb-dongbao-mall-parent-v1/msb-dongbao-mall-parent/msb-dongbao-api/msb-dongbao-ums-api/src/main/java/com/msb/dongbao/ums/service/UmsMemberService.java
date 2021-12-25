package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.common.base.ResultWrapper;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;


public interface UmsMemberService extends IService<UmsMember> {

    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    ResultWrapper edit(UmsMember umsMember);

    String mapper();
}
