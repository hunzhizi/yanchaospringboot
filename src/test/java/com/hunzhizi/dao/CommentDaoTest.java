package com.hunzhizi.dao;


import com.hunzhizi.domain.Comment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 12:50
 * @description:
 */
@SpringBootTest
public class CommentDaoTest  {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setContent("xdm，有无知道什么时候放暑假的");
        comment.setUserId(2);
        comment.setPostId(3);
        commentDao.createComment(comment);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setUpNum(100);
        comment.setDownNum(3);
        commentDao.updateComment(comment);
    }

    @Test
    public void getCommentByPostId() {
        List<Comment> commentByPostId = commentDao.getCommentByPostId(3);
        for (Comment comment : commentByPostId) {
            System.out.println(comment.getContent());
        }
    }


}
