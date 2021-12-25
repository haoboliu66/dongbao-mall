package com.msb.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper Interface
 * </p>
 *
 * @author hb
 * @since 2021-04-05
 */

@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectByName(String username);

    String selectInteger();

}
