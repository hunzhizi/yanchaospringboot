package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.PostDao;
import com.hunzhizi.dao.PostImgDao;
import com.hunzhizi.domain.Post;
import com.hunzhizi.domain.PostImg;
import com.hunzhizi.service.PostService;
import com.hunzhizi.util.PicUtil;
import com.qiniu.common.QiniuException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-02 11:26
 * @description:
 */
@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao postDao;
    @Resource
    private PostImgDao postImgDao;

    public boolean createPost(Post post) {

        return postDao.createPost(post);
    }

    public boolean delPostByPostId(Post post) {
        List<String> imgAddrList = post.getImgAddrList();
        for (String ImgName : imgAddrList) {
            try {
                //删除云服务器的内容。
                PicUtil.delFileByName(ImgName);
            } catch (QiniuException e) {
                log.info("postId:"+post.getPostId() +"postImgName"+ImgName+ "照片删除失败");
                return false;
            }
        }
        //删除数据库中图片的记录
        boolean delete = postImgDao.deleteByPostId(post.getPostId());
        //删除数据库中的帖子的记录
        return delete && postDao.delPostByPostId(post.getPostId());
    }

    public boolean updatePost(Post post) {
        post.setLastEditTime(new Date());

        return postDao.updatePost(post);
    }

    public List<Post> getPostByUserId(Integer userId) {
        return postDao.getPostByUserId(userId);
    }

    public PageInfo<Post> getPostByPriority(int postType,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Post> posts = postDao.getPostByPriority(postType);
        //下面要进行热度更新
        Post postTemp = new Post();
        for (Post post : posts) {
            //如果帖子的举报数量超过10 ，就将其delete掉
            if (post.getReportNum() != null && post.getReportNum() >= 10) {
                 postDao.delPostByPostId(post.getPostId());
            }
            post.setPriority();
            postTemp.setPriority(post.getPriority());
            postTemp.setPostId(post.getPostId());

            postDao.updatePost(postTemp);
        }
        return new PageInfo<Post>(posts);
    }

    public PageInfo<Post> getPostByLastEditTime(int postType,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Post> posts = postDao.getPostByLastEditTime(postType);
        return new PageInfo<Post>(posts);
    }

    @Override
    public Post getPostByPostId(Integer postId) {
        return postDao.getPostByPostId(postId);
    }

    @Override
    public PageInfo<Post> getPostByQuestionId(int parentZhiHu,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Post> posts = postDao.getPostByQuestionId(parentZhiHu);
        return new PageInfo<Post>(posts);
    }

    @Override
    public PageInfo<Post> getPostByContent(String str,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Post> posts = postDao.getPostByContent(str);
        return new PageInfo<Post>(posts);
    }
}
