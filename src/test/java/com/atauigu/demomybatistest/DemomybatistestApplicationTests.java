package com.atauigu.demomybatistest;

import com.atauigu.demomybatistest.Entity.User;
import com.atauigu.demomybatistest.mapper.UserMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemomybatistestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("Luck123321");
        user.setAge(20);
        user.setEmail("215381@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //修改
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId((long)1507);
        user.setName("ChangeName");

        int count = userMapper.updateById(user);
        System.out.println(count);

    }

    @Test
    public void findAll() {

        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
