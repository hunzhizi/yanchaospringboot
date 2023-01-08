package com.hunzhizi.controller;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.Post;
import com.hunzhizi.domain.PostImg;
import com.hunzhizi.service.PostImgService;
import com.hunzhizi.service.PostService;
import com.hunzhizi.util.PicUtil;
import com.qiniu.common.QiniuException;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-02 11:34
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;
    @Resource
    private PostImgService postImgService;

    @GetMapping("/{userId}")
    public Result getPostByUserId(@PathVariable Integer userId  ) {
        if (userId == null) return new Result(Code.PASS_VALUE_ERR);
        List<Post> postByUserId = postService.getPostByUserId(userId);

        return new Result(Code.POST_GET_OK, postByUserId);
    }

    @DeleteMapping("/{postId}")
    @Transactional
    public Result delPostByPostId(@PathVariable Integer postId) {
        if (postId == null) return new Result(Code.PASS_VALUE_ERR);
        Post post = postService.getPostByPostId(postId);
        boolean flag = postService.delPostByPostId(post);

        return (flag) ?
                new Result(Code.POST_DEL_OK) :
                new Result(Code.POST_DEL_ERR);
    }

    @PostMapping("/upload")
    @Transactional
    public Result uploadPic(@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest httpServletRequest) {
        String postId = httpServletRequest.getParameter("postId");
        String originalFilename = imgFile.getOriginalFilename();
        assert originalFilename != null;
        int i = originalFilename.lastIndexOf('.');
        String extension = originalFilename.substring(i - 1);
        UUID key = UUID.randomUUID();
        String newPicName = key.toString() + extension;
        boolean flag;
        try {
            String tempName = "src/main/resources/static/temp/" + newPicName;
            File img = new File(tempName);

            //利用Thumbnails 工具对图片进行压缩和水印处理
            Thumbnails.of(imgFile.getInputStream()).scale(0.5f)
                    .outputQuality(0.2f)
//                    .outputFormat("jpeg")
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("src/main/resources/static/img/ysu.png")), 0.4f)
                    .toFile(img);
            System.out.println("success2");

//            PicUtil.uploadByFileBytes(imgFile.getBytes(), newPicName);
            PicUtil.uploadByLocalFilePath(tempName,newPicName);

            PostImg postImg = new PostImg();
            postImg.setPostId(Integer.parseInt(postId));
            postImg.setImgName(newPicName);
            flag = postImgService.insert(postImg);

            //删除图片
            if(!img.delete()){
                throw new RuntimeException("图片删除失败");
            }
        } catch (Exception e) {
            log.info("postId:" + postId + "  post图片上传出现异常");
            return new Result(Code.FILE_UPLOAD_ERR, "文件上传失败");
        }
        return flag
                ? new Result(Code.FILE_UPLOAD_OK, (Object)newPicName)
                : new Result(Code.FILE_UPLOAD_ERR, "文件上传失败");
    }

    @PostMapping
    public Result createPost(@RequestBody Post post) {
        boolean flag = postService.createPost(post);
        return (flag ?
                new Result(Code.POST_SAVE_OK,post.getPostId()) :
                new Result(Code.POST_SAVE_ERR));
    }

    @GetMapping("/byPriority/{postType}/{pageNum}/{pageSize}")
    public Result getPostByPriority(@PathVariable Integer postType, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<Post> pageInfo = postService.getPostByPriority(postType, pageNum, pageSize);
        return (pageInfo != null
                ? new Result(Code.POST_GET_OK, pageInfo)
                : new Result(Code.POST_GET_ERR));

    }

    @GetMapping("/byLastEditTime/{postType}/{pageNum}/{pageSize}")
    public Result getPostByLastEditTime(@PathVariable Integer postType, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<Post> pageInfo = postService.getPostByLastEditTime(postType, pageNum, pageSize);
        return (pageInfo != null
                ? new Result(Code.POST_GET_OK, pageInfo)
                : new Result(Code.POST_GET_ERR));

    }

    @PutMapping
    public Result updatePost(@RequestBody Post post) {
        /**
         * TODO 处理上传文件相关代码在此
         */
        boolean flag = postService.updatePost(post);
        return (flag ? new Result(Code.POST_UPDATE_OK) : new Result(Code.POST_UPDATE_ERR));
    }

}
