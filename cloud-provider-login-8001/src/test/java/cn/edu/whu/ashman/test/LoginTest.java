package cn.edu.whu.ashman.test;

import cn.edu.whu.ashman.service.IUserService;
import cn.edu.whu.ashman.util.SmsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 登录模块测试
 *
 * @author Zhuyuhan
 * @date 2020-07-10 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginTest {

    @Autowired
    IUserService iUserService = null;

     public static String testPhoneNum1 = "15008225691";

     public static String testPhoneNum2 = "13476519330";

    @Test
    /**
     * 短信验证码发送单元测试
     */
    public void messageCodeTest(){
        SmsUtils.shortMesssageText(testPhoneNum1);
        SmsUtils.shortMesssageText(testPhoneNum2);
    }

}
