package com.atauigu.demomybatistest.handler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component//Spring中的知识，不加这个,类给到Spring，Spring不认识
public class MyMetaObjectHandle implements MetaObjectHandler{

    //mp执行添加操作，这个方法就执行
    @Override
    public void insertFill(MetaObject metaObject){
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("deleted",0,metaObject);//初始值0 0为不删除
    }

    //mp执行修改操作，这个方法就执行
    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
