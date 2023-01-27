package com.hunzhizi;

//import com.hunzhizi.controller.Listener.RabbitMqListener;

import com.hunzhizi.controller.PostController;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.Comment;
import com.hunzhizi.domain.CommentReply;
import com.hunzhizi.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName produceTest
 * TODO
 * @Date 2023/1/5 09:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yml")
public class produceTest {
    @Autowired
    private CommentService commentService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private PostController postController;


    @Test
    public void getPost(){
        Result postByPostId = postController.getPostByPostId(4);
        int i = 1;

    }

    @Test
    public void mqTest(){
        Comment comment = new Comment();//26,1,2,"redis测试"
//        comment.setCommentId(26);
        comment.setUserId(1);
        comment.setPostId(28);
        comment.setContent("redis测试15");
        commentService.createComment(comment);
//        System.out.println(result.toString());
    }
    @Test
    public void testRedis(){
        String queueName = "simple.queue";
        String name = "hunzhizi1";
        String post = "如何入门计科";
        String comment = "上课多睡觉!5";
        String message = name + "回复了您的帖子《" + post + "》:" + comment;
//        stringRedisTemplate.opsForValue().set("name:" + System.currentTimeMillis(),message,2, TimeUnit.DAYS);
        stringRedisTemplate.opsForList().rightPush("msg1",message);
        stringRedisTemplate.opsForList().getOperations().expire("msg1",2,TimeUnit.DAYS);
//        stringRedisTemplate.opsForHash().put("msg2","time" + System.currentTimeMillis(),message);
    }
    @Test
    public void testString() {
        List<CommentReply> msg = new ArrayList<>();
        Integer postUserId = 2;
        String postOwnerId = "msg" + postUserId;
        while (true) {
            String mssg = stringRedisTemplate.opsForList().leftPop(postOwnerId);
            if (mssg!=null) {
                int postId = 0;
                for (int i = 0; i < 11; i++) {
                    if (mssg.charAt(i)>='0'&&mssg.charAt(i)<='9'){
                        postId = postId * 10 + (mssg.charAt(i) - 48);
                    }else {
                        continue;
                    }
                }
                String uuId = postId + "分割";//删除字符串
                mssg = mssg.replace(uuId,"");
                msg.add(new CommentReply(postId,mssg));
            }else {
                break;
            }
        }
        if (msg.isEmpty()){
            System.out.println("没有最新消息");//返回特定值
        }else {
            System.out.println("你的帖子被评论啦");//返回帖子回复集合
        }
    }
//    @Test
//    public void testToSendMessage(){
//        String queueName = "simple.queue";
//        String name = "hunzhizi";
//        String post = "如何入门计科";
//        String comment = "上课多睡觉!";
//        String message = name + "回复了您的帖子《" + post + "》:" + comment;
//        rabbitTemplate.convertAndSend(queueName,message);
//    }
//
////    @Test
//    public void testToGetMessage(){
//        rabbitMqListener.listener1();
//    }
}
