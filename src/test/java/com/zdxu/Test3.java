package com.zdxu;

import com.zdxu.dao.DemoDao;
import com.zdxu.dao.TestDao;
import com.zdxu.service.DemoService;
import com.zdxu.service.DemoServiceImpl;
import org.easymock.*;
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
public class Test3 {

    @Autowired
    private DemoServiceImpl demoService3;

    @Test
    public void test3() {
        IMocksControl control = EasyMock.createStrictControl();
        DemoDao demoDao3 = control.createMock(DemoDao.class);
        TestDao testDao = control.createMock(TestDao.class);

        EasyMock.expect(testDao.test(EasyMock.anyString())).andReturn("xiao ming age is 24");

        EasyMock.expect(demoDao3.demo1(EasyMock.anyString(),
                EasyMock.anyInt(), EasyMock.anyString())).andReturn("zdxu");
        EasyMock.expect(demoDao3.demo2(EasyMock.anyInt())).andReturn(25);


        control.replay();
        demoService3.setDemoDao(demoDao3);
        demoService3.setTestDao(testDao);
        String returnValue = demoService3.demo2("da bai");
        System.out.println(returnValue);
        control.verify();
    }
}
