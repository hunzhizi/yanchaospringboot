package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.CommentDao;
import com.hunzhizi.dao.PostDao;
import com.hunzhizi.dao.UserDao;
import com.hunzhizi.domain.Comment;
import com.hunzhizi.domain.Post;
import com.hunzhizi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private UserDao userDao;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public boolean createComment(Comment comment) {
        Integer postId = comment.getPostId();
        postDao.plusCommentNum(postId);

        //redis消息推送
        Post post = postDao.getPostByPostId(postId);
        String postOwnerId = "msg" +  post.getUserId();
        String myPost = post.getContent();//帖子内容
        String theirName = userDao.get(comment.getUserId()).getNickname();//评论人昵称
        String theirComment = comment.getContent();//回复内容
        if (theirComment.length()>10){
            theirComment = theirComment.substring(0,10) + "······";
        }
        String message = theirName + "回复了您的帖子《" + myPost + "》:" + theirComment;
        stringRedisTemplate.opsForList().rightPush(postOwnerId,message);
        stringRedisTemplate.opsForList().getOperations().expire(postOwnerId,15, TimeUnit.DAYS);


        return commentDao.createComment(comment);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public List<String> getNewCommentByUserId(Integer userId) {
        List<String> msg = new ArrayList<>();
        String postOwnerId = "msg" + userId;
        while (true) {
            String mssg = stringRedisTemplate.opsForList().leftPop(postOwnerId);
            if (mssg!=null) {
                msg.add(mssg);
            }else {
                break;
            }
        }
        if (msg.isEmpty()){
            return null;//返回特定值
        }else {
            return msg;//返回帖子回复集合
        }
    }

    @Override
    public PageInfo<Comment> getCommentByPostId(Integer postId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentByPostId = commentDao.getCommentByPostId(postId);
        return new PageInfo<>(commentByPostId);
    }
}
