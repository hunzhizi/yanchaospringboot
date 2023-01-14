package com.hunzhizi.controller.results;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-29 19:55
 * @description: 返回值编码
 */
public class Code {
    //操作结果编码
    //user相关
    public static final Integer USER_SAVE_OK = 20011;
    public static final Integer USER_UPDATE_OK = 20021;
    public static final Integer USER_GET_OK = 20041;
    public static final Integer PROFILE_GET_OK = 20051;


    public static final Integer USER_SAVE_ERR = 20010;
    public static final Integer USER_UPDATE_ERR = 20020;
    public static final Integer USER_GET_ERR = 20040;
    public static final Integer PROFILE_GET_ERR = 20050;

    //post 相关
    public static final Integer POST_SAVE_OK = 20111;
    public static final Integer POST_UPDATE_OK = 20121;
    public static final Integer POST_DEL_OK = 20131;
    public static final Integer POST_GET_OK = 20141;
//    public static final Integer PROFILE_GET_OK = 20051;

    public static final Integer POST_SAVE_ERR = 20110;
    public static final Integer POST_UPDATE_ERR = 20120;
    public static final Integer POST_DEL_ERR = 20130;
    public static final Integer POST_GET_ERR = 20140;
//    public static final Integer PROFILE_GET_ERR = 20050;

    //comment 相关
    public static final Integer COMMENT_SAVE_OK = 20211;
    public static final Integer COMMENT_UPDATE_OK = 20221;
    public static final Integer COMMENT_REPLY_OK = 20231;
    public static final Integer COMMENT_GET_OK = 20241;

    public static final Integer COMMENT_SAVE_ERR = 20210;
    public static final Integer COMMENT_UPDATE_ERR = 20220;
    public static final Integer COMMENT_REPLY_ERR = 20230;
    public static final Integer COMMENT_GET_ERR = 20240;

    //activity 相关
    public static final Integer ACTIVITY_SAVE_OK = 20311;
    public static final Integer ACTIVITY_UPDATE_OK = 20321;
    public static final Integer ACTIVITY_GET_OK = 20341;

    public static final Integer ACTIVITY_SAVE_ERR = 20310;
    public static final Integer ACTIVITY_UPDATE_ERR = 20320;
    public static final Integer ACTIVITY_GET_ERR = 20340;

    //activityCommit 相关
    public static final Integer ACTIVITY_COMMIT_SAVE_OK = 20411;
    public static final Integer ACTIVITY_COMMIT_DEL_OK = 20431;
    public static final Integer ACTIVITY_COMMIT_GET_OK = 20441;

    public static final Integer ACTIVITY_COMMIT_SAVE_ERR = 20410;
    public static final Integer ACTIVITY_COMMIT_DEL_ERR = 20430;
    public static final Integer ACTIVITY_COMMIT_GET_ERR = 20440;

    //certificate 相关
    public static final Integer CERTIFICATE_SAVE_OK = 20511;
    public static final Integer CERTIFICATE_UPDATE_OK = 20521;
    public static final Integer CERTIFICATE_DEL_OK = 20531;
    public static final Integer CERTIFICATE_GET_OK = 20541;

    public static final Integer CERTIFICATE_SAVE_ERR = 20510;
    public static final Integer CERTIFICATE_UPDATE_ERR = 20520;
    public static final Integer CERTIFICATE_DEL_ERR = 20530;
    public static final Integer CERTIFICATE_GET_ERR = 20540;

    //certificate 相关
    public static final Integer ZHI_HU_SAVE_OK = 20611;
    public static final Integer ZHI_HU_UPDATE_OK = 20621;
    public static final Integer ZHI_HU_DEL_OK = 20631;
    public static final Integer ZHI_HU_GET_OK = 20641;

    public static final Integer ZHI_HU_SAVE_ERR = 20610;
    public static final Integer ZHI_HU_UPDATE_ERR = 20620;
    public static final Integer ZHI_HU_DEL_ERR = 20630;
    public static final Integer ZHI_HU_GET_ERR = 20640;

    //collection 相关
    public static final Integer COLLECTION_SAVE_OK = 20711;
    public static final Integer COLLECTION_UPDATE_OK = 20721;
    public static final Integer COLLECTION_DEL_OK = 20731;
    public static final Integer COLLECTION_GET_OK = 20741;

    public static final Integer COLLECTION_SAVE_ERR = 20710;
    public static final Integer COLLECTION_UPDATE_ERR = 20720;
    public static final Integer COLLECTION_DEL_ERR = 20730;
    public static final Integer COLLECTION_GET_ERR = 20740;

    //WechatAuth 认证相关

    public static final Integer WECHATAUTH_GET_OK = 20841;

    public static final Integer WECHATAUTH_GET_ERR = 20840;


    //系统错误编码
    public static final Integer PASS_VALUE_ERR = 30000; //传值错误，例如：userId 为null
    public static final Integer FILE_UPLOAD_ERR = 30010; //表示文件上传时候的错误
    public static final Integer FILE_UPLOAD_OK = 30011; //表示文件上传时候的错误

    //操作权限编码

    //校验结果编码
}
