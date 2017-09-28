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
public class Test2 {

    @Rule
    public EasyMockRule mocks = new EasyMockRule(this);

    @TestSubject
    @Autowired
    private DemoService demoService2;

    @Mock(type = MockType.STRICT, name = "demoDao2", fieldName = "demoDao")
    public DemoDao demoDao2;

    @Test
    public void test2() {
        String name = "zdxu";
//        EasyMock.expect(demoDao2.demo1(EasyMock.anyString(),
//                EasyMock.anyInt(), EasyMock.anyString())).andReturn(name);
//        EasyMock.expect(demoDao2.demo2(EasyMock.anyInt())).andReturn(25);

        demoDao2.demo1(EasyMock.anyString(), EasyMock.anyInt(), EasyMock.anyString());
        EasyMock.expectLastCall().andReturn("zdxu");

        demoDao2.demo2(EasyMock.anyInt());
        EasyMock.expectLastCall().andReturn(25);

        EasyMock.replay(demoDao2);
        String returnValue = demoService2.demo("1234");
        System.out.println(returnValue);

        EasyMock.reset(demoDao2);
        demoDao2.demo1(EasyMock.anyString(), EasyMock.anyInt(), EasyMock.anyString());
        EasyMock.expectLastCall().andReturn("zdxu");

        demoDao2.demo2(EasyMock.anyInt());
        EasyMock.expectLastCall().andReturn(25);

        EasyMock.replay(demoDao2);

        System.out.println(demoService2.demo("1234"));
        Assert.assertTrue(returnValue.contains(name));
        EasyMock.verify(demoDao2);
    }
}
