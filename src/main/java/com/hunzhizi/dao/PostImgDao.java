package com.hunzhizi.dao;

import com.hunzhizi.domain.PostImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 魂之子
 * @since 2022-06-03 20:06
 * program: yanchaospringboot
 * description:用于进行图片信息的存储
 */
@Mapper
public interface PostImgDao {
    @Insert("insert into post_img(post_id,img_name) " +
            "values(#{postId},#{imgName})")
    boolean insert(PostImg postImg);
    @Delete("delete from post_img " +
            "where post_id = #{postId}")
    boolean deleteByPostId(Integer postId);

    @Select("select img_name from post_img " +
            "where post_id = #{postId}")
    List<String> selectByPostId(Integer postId);
}
