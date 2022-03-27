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

    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        //根据id查询
        User user = userMapper.selectById(15081L);
        //修改
        user.setName("Mr.LeLocker");
        //插件中已经做了下面的+1操作，所以自己不用再加了
        //user.setVersion(user.getVersion()+1);
        userMapper.updateById(user);

    }

    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("Lockmiss");
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
