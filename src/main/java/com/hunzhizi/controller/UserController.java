package com.hunzhizi.controller;

import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.User;
import com.hunzhizi.service.UserService;
import com.hunzhizi.util.FileUtil;
import com.hunzhizi.util.PicUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 魂之子
 * @program: springMVC
 * @create: 2022-04-12 13:16
 * @description:
 */
@RestController
@Slf4j
@RequestMapping("/user")
//注意，在这里的命名，同你的控制器的作用相同，在这里是UserController 所以使用user作为一个根的访问路径
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.addUser(user);
        return new Result(flag ? Code.USER_SAVE_OK : Code.USER_SAVE_ERR);
    }

    @PostMapping("/upload")
    @Transactional
    public Result uploadPic(@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request) {

        String key = request.getParameter("userId");
        String oldProfileName = request.getParameter("oldProfileName");
        String originalFilename = imgFile.getOriginalFilename();
//        System.out.println(originalFilename);
        assert originalFilename != null;
        int i = originalFilename.lastIndexOf('.');
        String extension = originalFilename.substring(i);
        String uuid = UUID.randomUUID().toString();
//        String newFileName = key + extension;
        String newFileName = uuid + extension;
        boolean flag ;
        try {
            //删除老的文件名称
            if(oldProfileName!=null && !oldProfileName.equals("")){
                PicUtil.delFileByName(oldProfileName);

            }
            PicUtil.uploadByFileBytes(imgFile.getBytes(), newFileName);
            //更新数据库中，新图片的名称
            User user = new User();
            user.setUserId(Integer.parseInt(key));
            user.setProfileAddr(newFileName);
            flag =  userService.updateUser(user);
        } catch (IOException e) {
            log.info("文件获取失败" + e);
            return new Result(Code.FILE_UPLOAD_ERR, "文件上传失败");
        }
        return  flag
                ? new Result(Code.FILE_UPLOAD_OK, (Object)newFileName)
                : new Result(Code.FILE_UPLOAD_ERR, "文件上传失败");

    }

    @PutMapping
    public Result update(@RequestBody User user/*, MultipartFile img*/) {
        /*if (!(img == null || img.isEmpty())) {
            try {
                String addr = FileUtil.setFileAddr(user.getUserId(), img);
                img.transferTo(new File(addr));
                user.setProfileAddr(addr);
            } catch (IOException e) {
                e.printStackTrace();
                return new Result(Code.USER_UPDATE_ERR);
            }
        }
        System.out.println(FileUtil.setFileAddr(user.getUserId(), img));
        System.out.println(user.getBio());*/
        boolean flag = userService.updateUser(user);
        return new Result(flag ? Code.USER_UPDATE_OK : Code.USER_UPDATE_ERR);
    }


    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public Result getProfile(String imgpath) {
        File file = new File(imgpath);
        if (file.exists()) {
            BufferedImage image = null;
            try {
                FileInputStream in = new FileInputStream(file);
                image = ImageIO.read(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                return new Result(Code.PROFILE_GET_ERR);
            }
            return new Result(Code.PROFILE_GET_OK, image);
        }
        return new Result(Code.PROFILE_GET_ERR);
    }
//    @RequestMapping("/fileupload")
//    public Result update(  MultipartFile img){
//        if(img == null){
//            System.out.println("img is null");
//        }else {
//            System.out.println("ok");
//        }
//
//        return null;
//    }


    @GetMapping("/{userid}")
    public Result get(@PathVariable Integer userid) {
        User user = userService.getUserById(userid);
        return (user != null ? new Result(Code.USER_GET_OK, user) : new Result(Code.USER_GET_ERR));
    }

//    @GetMapping("/{pageNum}/{pageSize}")
//    public PageInfo<User> getAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
//        return userService.getAll(pageNum,pageSize);
//
//    }


}
