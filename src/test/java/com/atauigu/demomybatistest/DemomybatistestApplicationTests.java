package com.atauigu.demomybatistest;

import com.atauigu.demomybatistest.Entity.User;
import com.atauigu.demomybatistest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.var;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.*;

@SpringBootTest
class DemomybatistestApplicationTests {

    @Autowired
    private UserMapper userMapper;


    //用mp实现复杂查询操作
    @Test
    public void testSelect0(){
        //ge gt le lt
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //也可以用父类Wrapper构建，不过QueryWrapper功能更强大
        queryWrapper.ge("age", 22);
        queryWrapper.eq("name","Dennis");
        queryWrapper.between("age", 20, 30);
        queryWrapper
                .select("name", "age")
                .like("name", "e")
                .likeRight("email", "5");
        queryWrapper.orderByDesc("age", "id");

        //Useruser = userMapper.selectOne(queryWrapper);
        //List<Map<String, Object>> maps =userMapper.selectMaps(queryWrapper);
        List<User> users = userMapper.selectList(queryWrapper);

        System.out.println(users);
    }

    /**
     * 删除
     */
    //根据ID删除
    @Test
    public void testDeleteById(){
        int rows = userMapper.deleteById(1508190241519927298L);
        System.out.println(rows);
    }

    //根据ID批量删除
    @Test
    public void testDeleteBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(result);
    }

    //简单条件删除
    @Test
    public void testDeleteByMap(){
        //根据名称和年龄删除
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Dennis");
        map.put("age", 20);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /**
     * 查询
     */
    //分页查询
    @Test
    //1.先要在配置类config中配置插件才能使用
    //2.编写分页代码(使用Page对象，传入两个参数，*当前页 *每页记录数)，然后调用mp使用分页
    public void testSelect3(){
        //当前页是1，每页显示记录3个
        Page<User> page = new Page(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        long pages = userPage.getPages();//总页数
        long current = userPage.getCurrent();//当前页
        List<User> records = userPage.getRecords();//当前查询数据的集合
        long total = userPage.getTotal();//表中的总记录数
        boolean hasNext = userPage.hasNext();//是否有下一页
        boolean hasPrevious = userPage.hasPrevious();//是否有上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);


    }

    //简单的条件查询
    @Test
    public void testSelect2(){
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name","Dennis");
        columnMap.put("age",23);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }

    //多个id批量查询
    @Test
    public void testSelect1(){
        //查询Id为1，为2，为3的数据，输出数据行
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);

    }


    /**
     * 乐观锁
     */
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

    /**
     * 普通方法 增改查
     */
    //添加
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("JRP");
        user.setAge(20);
        user.setEmail("215381@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //修改
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1507L);
        user.setName("ChangeName");

        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void testDelete(){
        int result = userMapper.deleteById(8);
        System.out.println(result);
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
