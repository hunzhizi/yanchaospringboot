package com.hunzhizi.controller;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.Post;
import com.hunzhizi.service.MyCollectionService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2022-05-31 14:47
 * program: yanchaospringboot
 * description:
 */
@RestController
@RequestMapping("/collections")
public class MyCollectionController {
    @Resource
    MyCollectionService myCollectionService;

    @GetMapping("/{userId}")
    public Result getCollectionsByUserId(@PathVariable Integer userId){
        PageInfo<Post> pageInfo = myCollectionService.getCollectionsByUserId(userId);
        return (pageInfo != null
                ? new Result(Code.COLLECTION_GET_OK, pageInfo)
                : new Result(Code.COLLECTION_GET_ERR));
    }

    @DeleteMapping("/{userId}/{postId}")
    public Result delete(@PathVariable Integer userId, @PathVariable Integer postId){
        boolean delete = myCollectionService.delete(userId, postId);
        return delete?
                new Result(Code.COLLECTION_DEL_OK):
                new Result(Code.COLLECTION_DEL_ERR);

    }

    @PutMapping("/{userId}/{postId}")
    public Result insert(@PathVariable Integer userId, @PathVariable Integer postId){
        boolean flag = myCollectionService.insert(userId, postId);
        return flag?
                new Result(Code.COLLECTION_SAVE_OK):
                new Result(Code.COLLECTION_SAVE_ERR);

    }

}
