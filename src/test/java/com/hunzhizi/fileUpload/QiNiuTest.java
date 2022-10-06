package com.hunzhizi.fileUpload;

import com.google.gson.Gson;
import com.hunzhizi.YanchaoSpringbootApplication;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 魂之子
 * @since 2022-06-02 23:40
 * program: yanchaospringboot
 * description:
 */

@SpringBootTest(classes = YanchaoSpringbootApplication.class)
public class QiNiuTest {
    @Test
    public void test01() {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.regionAs0());
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "A5WkIaePH3La1s8eoSjxUIrdK0ZjLidvIaXz0L5p";
        String secretKey = "8Nlbrk_N0JUrEU8MrR3Zu5yKlKM-v20rRtvoGFPQ";
        String bucket = "yanchaoabroad";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "C:\\Users\\29024\\Pictures\\Saved Pictures\\maomao.jpg";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

    }
    @Test
    public void testDel(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region1());
//...其他参数参考类注释

        String accessKey = "A5WkIaePH3La1s8eoSjxUIrdK0ZjLidvIaXz0L5p";
        String secretKey = "8Nlbrk_N0JUrEU8MrR3Zu5yKlKM-v20rRtvoGFPQ";

        String bucket = "yanchao";
        String key = "Fv51D4P_8E8nEXz8PUhnK-SYU8hQ";

        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }

    }


}
