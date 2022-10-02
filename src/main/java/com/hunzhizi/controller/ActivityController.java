package com.hunzhizi.controller;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.Activity;
import com.hunzhizi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 16:17
 * @description:
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public Result createActivity(@RequestBody Activity activity) {
        boolean flag = activityService.createActivity(activity);
        return flag ?
                new Result(Code.ACTIVITY_SAVE_OK) :
                new Result(Code.ACTIVITY_SAVE_ERR);
    }

    //修改活动
    @PutMapping
    public Result updateActivity(@RequestBody Activity activity) {
        boolean flag = activityService.updateActivity(activity);
        return flag ?
                new Result(Code.ACTIVITY_UPDATE_OK) :
                new Result(Code.ACTIVITY_UPDATE_ERR);
    }

    //获取活动信息byId
    @GetMapping("/{activityId}")
    public Result getActivityById(@PathVariable Integer activityId) {
        Activity activity = activityService.getActivityById(activityId);
        return activity != null ?
                new Result(Code.ACTIVITY_GET_OK, activity) :
                new Result(Code.ACTIVITY_GET_ERR);
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public Result getAllActivity(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<Activity> allActivity = activityService.getAllActivity(pageNum, pageSize);
        return new Result(Code.ACTIVITY_GET_OK, allActivity);
    }

    //根据用户id获取改用户组织的活动
    @GetMapping("/{pageNum}/{pageSize}/{userId}")
    public Result getActivityByUserId(@PathVariable Integer pageNum,@PathVariable Integer pageSize,@PathVariable Integer userId){
        PageInfo<Activity> activityByUserId = activityService.getActivityByUserId(pageNum, pageSize, userId);
        return new Result(Code.ACTIVITY_GET_OK,activityByUserId);
    }

}
