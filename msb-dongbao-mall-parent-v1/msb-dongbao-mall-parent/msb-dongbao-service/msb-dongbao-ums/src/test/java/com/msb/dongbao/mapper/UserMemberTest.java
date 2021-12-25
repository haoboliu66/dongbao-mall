package com.msb.dongbao.mapper;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMemberTest {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Test
    void testInsert() {
        UmsMember m = new UmsMember();
        m.setUsername("andy123456");
        m.setPassword("123456789");
        m.setStatus(0);
        m.setNickName("nick-nick-nick");
        m.setEmail("hello@gmail.com");

        umsMemberMapper.insert(m);

    }
}
