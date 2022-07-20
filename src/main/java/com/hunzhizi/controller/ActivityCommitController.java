package com.hunzhizi.controller;

import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.ActivityCommit;
import com.hunzhizi.service.ActivityCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-08 18:57
 * @description:
 */
@RestController
@RequestMapping("/activityCommit")
public class ActivityCommitController {
    @Autowired
    private ActivityCommitService commitService;

    @PostMapping
    public Result createCommit(@RequestBody ActivityCommit commit) {
        boolean flag = commitService.createCommit(commit);
        return flag ?
                new Result(Code.ACTIVITY_COMMIT_SAVE_OK) :
                new Result(Code.ACTIVITY_COMMIT_SAVE_ERR);

    }

    @DeleteMapping("/{userId}/{activityId}")
    public Result deleteCommitByUserId(@PathVariable Integer userId, @PathVariable Integer activityId) {
        boolean flag = commitService.deleteCommitByUserIdNActivityId(userId, activityId);
        return flag ?
                new Result(Code.ACTIVITY_COMMIT_DEL_OK) :
                new Result(Code.ACTIVITY_COMMIT_DEL_ERR);
    }

    @GetMapping("/{userId}/{activityId}")
    public Result getCommitByUserId(@PathVariable Integer userId, @PathVariable Integer activityId) {
        ActivityCommit commit = commitService.getCommitByUserIdNActivityId(userId, activityId);
        return commit != null ?
                new Result(Code.ACTIVITY_COMMIT_GET_OK, commit) :
                new Result(Code.ACTIVITY_COMMIT_GET_ERR, "未报名");
    }
}
