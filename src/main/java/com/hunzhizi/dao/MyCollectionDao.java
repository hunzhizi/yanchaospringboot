package com.hunzhizi.dao;

import com.hunzhizi.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 魂之子
 * @since 2022-05-31 12:47
 * program: yanchaospringboot
 * description:
 */
@Mapper
public interface MyCollectionDao {
    @Insert("insert into my_collection(user_id,post_id)" +
            "values(#{userId},#{postId})")
    boolean insert(@Param("userId") Integer userId ,@Param("postId") Integer postId);

    @Delete("delete from my_collection " +
            "where user_id = #{userId} and post_id = #{postId}")
    boolean delete (@Param("userId") Integer userId ,@Param("postId") Integer postId);


    List<Post> getCollectionsByUser(Integer userId);
}
