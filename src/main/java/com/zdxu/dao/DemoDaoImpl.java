package com.zdxu.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhdxu on 2017/9/28.
 */
@Component
public class DemoDaoImpl implements DemoDao {

    public String demo1(String name, int age, String nickname) {
        return name;
    }

    @Override
    public int demo2(int age) {
        return age;
    }
}
