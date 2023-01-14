package com.hunzhizi.toolTest;

import com.alibaba.druid.support.json.JSONParser;
import com.hunzhizi.YanchaoSpringbootApplication;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 魂之子
 * @since 2023-01-10 14:43
 * program: yanchaospringboot
 * description:
 */
@SpringBootTest(classes = YanchaoSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class HttpTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void RestTemplateTestGet() {
        /**
         * getForObject
         * 参数1 要请求的地址的url  必填项
         * 参数2 响应数据的类型 是String 还是 Map等 必填项
         * 参数3 请求携带参数 选填
         * getForObject 方法的返回值就是 被调用接口响应的数据
         */
        String url = "https://api.weixin.qq.com/sns/jscode2session";
//        Map<String, String> requestUrlParam = new HashMap<>();
//        //小程序appId
//        requestUrlParam.put("appid", "wx8947fb8a973be9ce");
//        //小程序secret
//        requestUrlParam.put("secret", "9942313579547fa946c356d7dd345250");
//        //小程序端返回的code
//        requestUrlParam.put("js_code", "043xrR000ob4fP1wvh300vTBUd3xrR0d");
        url += "?appid=" + "wx8947fb8a973be9ce" + "&secret=" + "9942313579547fa946c356d7dd345250"
                 + "&js_code=" + "073NwE000OPhfP1uT7100PyRjh3NwE0S";
                /*"&grant_type=authorization_code"*/;
        System.out.println(url);

        try {
            JSONParser jsonParser = new JSONParser(restTemplate.getForObject(url, String.class));
            Map<String, Object> stringObjectMap = jsonParser.parseMap();
//            openid = jsonParser.get("openid");
            Object openid1 = stringObjectMap.get("openid");
            System.out.println("openid=" + openid1);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

//        try {
//            JSONObject jsonObject = new JSONObject(restTemplate.getForObject(url, String.class));
//            Object openid = jsonObject.get("openid");
//            System.out.println(openid);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        //1. getForObject()
        //先获取返回的字符串，若想获取属性，可以使用gson转化为实体后get方法获取
//        String result = restTemplate.getForObject(url, String.class );
//        System.out.println(result);//{"code":"0","data":{"address":"北京市海淀区","id":1,"password":"123456","role":0,"sex":0,"telephone":"10086","username":"小明"},"msg":"操作成功"}

        //2. getForEntity()
        //获取实体ResponseEntity，可以用get函数获取相关信息
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("responseEntity.getStatusCode() = " + responseEntity.getStatusCode());

        System.out.println("responseEntity.getStatusCodeValue() = " + responseEntity.getStatusCodeValue()); //responseEntity.getStatusCodeValue() = 200

        System.out.println("responseEntity.getBody() = " + responseEntity.getBody());   //responseEntity.getBody() = {"code":"0","data":{"address":"北京市海淀区","id":1,"password":"123456","role":0,"sex":0,"telephone":"10086","username":"小明"},"msg":"操作成功"}

        System.out.println("responseEntity.getHeaders() = " + responseEntity.getHeaders());//responseEntity.getHeaders() = [Content-Type:"application/json", Content-Length:"158", Server:"Werkzeug/0.14.1 Python/3.7.0", Date:"Sat, 16 Oct 2021 06:01:26 GMT"]

        System.out.println("responseEntity.getClass() = " + responseEntity.getClass());//responseEntity.getClass() = class org.springframework.http.ResponseEntity

    }

}
