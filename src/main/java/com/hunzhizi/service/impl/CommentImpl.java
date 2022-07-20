package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.CommentDao;
import com.hunzhizi.dao.PostDao;
import com.hunzhizi.domain.Comment;
import com.hunzhizi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 13:03
 * @description:
 */
@Service
public class CommentImpl implements CommentService {

    @Resource
    private CommentDao commentDao;
    @Resource
    private PostDao postDao;

    @Override
    public boolean createComment(Comment comment) {
        Integer postId = comment.getPostId();
        postDao.plusCommentNum(postId);
        return commentDao.createComment(comment);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public PageInfo<Comment> getCommentByPostId(Integer postId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentByPostId = commentDao.getCommentByPostId(postId);
        return new PageInfo<>(commentByPostId);
    }
}
