package com.hunzhizi.dao;

import com.hunzhizi.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-02 10:05
 * @description:
 */
@Mapper
public interface PostDao {
    boolean createPost(Post post);

    boolean delPostByPostId(Integer postId);

    boolean updatePost(Post post);

    @Update("update post set comment_num = comment_num +1 " +
            "where post_id = #{postId}")
    boolean plusCommentNum(@Param("postId") Integer postId);

    List<Post> getPostByUserId(Integer userId);

    List<Post> getPostByPriority(Integer postType);

    List<Post> getPostByLastEditTime(Integer postType);

    Post getPostByPostId(Integer postId);

    List<Post> getPostByQuestionId(Integer parentZhiHu);

    List<Post> getPostByContent(String str);
}
