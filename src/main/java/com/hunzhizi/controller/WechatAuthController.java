package com.hunzhizi.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.User;
import com.hunzhizi.service.WechatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.Map;


/**
 * @author 魂之子
 * @since 2022-08-26 14:10
 * program: yanchaospringboot
 * description:
 */
@RestController
@RequestMapping("/auth")
public class WechatAuthController {
    private final static String APPID = "wx8947fb8a973be9ce";
    private final static String SECRET = "9942313579547fa946c356d7dd345250";
    private final static String WECHAT_URL = "https://api.weixin.qq.com/sns/jscode2session";
    @Resource
    WechatAuthService authService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public Result auth(@RequestParam("code") String code){
        String url = WECHAT_URL;
        url += "?appid=" + APPID + "&secret=" + SECRET +
                "&js_code=" + code;

        Object openid = null;
        try {
            JSONParser jsonParser = new JSONParser(restTemplate.getForObject(url, String.class));
            Map<String, Object> stringObjectMap = jsonParser.parseMap();
//            openid = jsonParser.get("openid");
            openid = stringObjectMap.get("openid");
        } catch (RestClientException e) {
            throw new RuntimeException("登录时微信服务器返回参数解析错误");
        }

        assert openid != null;
        User user = authService.getUserByOpenId(openid.toString());
        return new Result(Code.WECHATAUTH_GET_OK,user);
    }

}
