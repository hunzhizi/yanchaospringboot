package com.hunzhizi.dao;

import com.hunzhizi.domain.WechatAuth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 魂之子
 * @since 2022-08-26 13:34
 * program: yanchaospringboot
 * description:
 */
@Mapper
public interface WechatAuthDao {
    @Select("select * from wechat_auth where open_id = #{openId}")
    WechatAuth getWechatAuthByOpenId(@Param("openId") String openId);

    @Insert("insert into wechat_auth(open_id,user_id)" +
            " values(#{openId},#{userId})")
    Boolean insert(WechatAuth wechatAuth);
}

