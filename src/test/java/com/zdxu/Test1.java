package com.zdxu;

import com.zdxu.dao.DemoDao;
import com.zdxu.service.DemoService;
import com.zdxu.service.DemoServiceImpl;
import org.easymock.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhdxu on 2017/9/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyMain.class)
public class Test1 {

    @Autowired
    private DemoServiceImpl demoService;

    @Test
    public void test1() {
        String name = "xuzd";
        DemoDao demoDao1 = EasyMock.createMock(DemoDao.class);
        EasyMock.expect(demoDao1.demo1(EasyMock.anyString(), EasyMock.anyInt(),
                EasyMock.anyString())).andReturn(name);
        EasyMock.replay(demoDao1);

        demoService.setDemoDao(demoDao1);
        String returnValue = demoService.demo("1234");
        Assert.assertTrue(returnValue.contains(name));

        EasyMock.verify(demoDao1);
    }


}
