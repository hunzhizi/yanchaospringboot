package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.Comment;
import com.hunzhizi.domain.CommentReply;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 13:02
 * @description:
 */
@Transactional
public interface CommentService {
    boolean createComment(Comment comment);

    boolean updateComment(Comment comment);

    List<CommentReply> getNewCommentByUserId(Integer userId);

    @Transactional(readOnly = true)
    PageInfo<Comment> getCommentByPostId(Integer postId, Integer pageNum, Integer pageSize);
}
