package cn.edu.whu.ashman.config;

import cn.edu.whu.ashman.util.COSUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 密钥配置类
 *
 * @author Zhuyuhan
 * @date 2020-07-16 10:55
 */
@Configuration
public class COSClientConfig {
    public static final String SECRET_ID = "123456";
    public static final String SECRET_KEY = "123456";
    public static final String COS_REGION = "ap-chengdu";
    public static final String APPID = "1301866798";
    public static final String PREFIX = "https://picturebed-1301866798.cos.ap-chengdu.myqcloud.com/";

    @Bean
    public COSClient getCosClient(){
        COSCredentials cred = new BasicCOSCredentials(SECRET_ID, SECRET_KEY);
       // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
       // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(COS_REGION);
        ClientConfig clientConfig = new ClientConfig(region);
       // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }
    @Bean
    public COSUtil getCOSUtil(){
        return new COSUtil();
    }
}
