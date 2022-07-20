package com.hunzhizi.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author 魂之子
 * @since 2022-06-03 16:17
 * program: yanchaospringboot
 * description:
 */
@Component
public class PicUtil {
    private static final String accessKey = "A5WkIaePH3La1s8eoSjxUIrdK0ZjLidvIaXz0L5p";
    private static final String secretKey = "8Nlbrk_N0JUrEU8MrR3Zu5yKlKM-v20rRtvoGFPQ";
    private static final String bucket = "yanchao";
    private static final Auth auth = Auth.create(accessKey, secretKey);
    //构造一个带指定 Region 对象的配置类
    private static final Configuration cfg = new Configuration(Region.region1());
    private static final UploadManager uploadManager = new UploadManager(cfg);
    private static final BucketManager bucketManager = new BucketManager(auth, cfg);


    public static void uploadByFilePath(String localFilePath){
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

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
    public static void uploadByFileBytes(byte[] uploadBytes,String key) throws QiniuException {
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String upToken = auth.uploadToken(bucket);


            Response response = uploadManager.put(uploadBytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);


    }
    public static void delFileByName(String key) throws QiniuException {
            bucketManager.delete(bucket, key);
    }



    /**
     * 对图片进行压缩和加水印的处理，暂时先不使用
     * @param mFile
     * @throws IOException
     */
   /* public static void scalingImgAndPutWatermark(MultipartFile mFile) throws IOException {


        Thumbnails.of(mFile.getInputStream())
                .scale(0.25)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("src/main/resources/static/img/ysu.png")), 0.5f)
                .outputQuality(0.8)
                .toFile(mFile);

    }*/


}
