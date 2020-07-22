package cn.edu.whu.ashman.test;

import cn.edu.whu.ashman.util.COSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Zhuyuhan
 * @date 2020-07-16 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class COSClientTest {
    @Autowired
    private COSUtil cosUtil;

    @Test
    public void listTest(){
        cosUtil.getBucketList();
    }

    @Test
    public void urlTest(){
        System.out.println(cosUtil.getURL("1.jpg"));
        //cosUtil.getBucketList();
    }

    @Test
    public void saveTest(){
        cosUtil.save("D:\\images\\test4.jpg","test4.jpg");
    }

    @Test
    public void testAll(){
        cosUtil.save("D:\\images\\test6.jpg","test6.jpg");
        System.out.println(cosUtil.getURL("test6.jpg"));
    }
}
