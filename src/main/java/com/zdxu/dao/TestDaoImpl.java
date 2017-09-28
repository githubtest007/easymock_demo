package com.zdxu.dao;

import org.springframework.stereotype.Component;

/**
 * Created by zhdxu on 2017/9/28.
 */
@Component
public class TestDaoImpl implements TestDao {

    @Override
    public String test(String value) {
        return value;
    }
}
