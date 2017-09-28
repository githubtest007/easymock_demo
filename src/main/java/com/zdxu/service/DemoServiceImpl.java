package com.zdxu.service;

import com.zdxu.dao.DemoDao;
import com.zdxu.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhdxu on 2017/9/28.
 */
@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private TestDao testDao;

    @Autowired
    private DemoDao demoDao;

    public void setDemoDao(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public String demo(String name) {
        String username =  demoDao.demo1(name, 25, "小猪");
        int age = demoDao.demo2(25);
        return username + " is " + age;
    }

    @Override
    public String demo2(String name) {
        String username =  demoDao.demo1(name, 25, "小猪");
        int age = demoDao.demo2(25);
        String value = testDao.test(username+" age is "+age);
        return value;
    }
}
