package cn.edu.whu.ashman.util;

import cn.edu.whu.ashman.config.COSClientConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * @author Zhuyuhan
 * @date 2020-07-16 11:06
 */
public class COSUtil {
    @Autowired
    private COSClient cosClient;
    @Value("${bucketName}")
    private String bucketName;
    @Value("${bucketLocation}")
    private String bucketLocation;

    public void getBucketList(){
        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucketElement : buckets) {
            String bucketName = bucketElement.getName();
            String bucketLocation = bucketElement.getLocation();
            System.out.println(bucketElement);
        }
    }

    /**
     * 获取存储桶中对象url
     */
    public String getURL(String filename){
        // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        System.out.println(bucketName);
        /**
         * 对象键（Key）是对象在存储桶中的唯一标识。
         * 例如，在对象的访问域名
         * examplebucket-1250000000.cos.ap-guangzhou.myqcloud.com/images/picture.jpg 中，
         * 对象键为 images/picture.jpg，详情请参见 对象键 的说明。
         */
        String key = filename;
        System.out.println("key:"+filename);
        System.out.println("我进行到发api请求之前啦");
        GeneratePresignedUrlRequest req =
                new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        // 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
        // 这里设置签名在半个小时后过期
        Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
        req.setExpiration(expirationDate);
        URL url = cosClient.generatePresignedUrl(req);
        cosClient.shutdown();
        return url.toString();
    }

    /**
     * 存储文件 Key:File
     * @param localPath 绝对路径
     * @param filename key
     */
    public void save(String localPath,String filename){
        // 指定要上传的文件
        File localFile = new File(localPath);
        // 指定要上传到的存储桶
        //String bucketName = "examplebucket-1250000000";
        // 指定要上传到 COS 上对象键
        String key = filename;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

    }
}
