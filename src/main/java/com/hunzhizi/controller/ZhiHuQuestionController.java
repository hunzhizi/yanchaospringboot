package com.hunzhizi.controller;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.ZhiHuQuestion;
import com.hunzhizi.service.ZhiHuQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 17:12
 * @description:
 */
@RestController
@RequestMapping("/question")
public class ZhiHuQuestionController {
    @Autowired
    private ZhiHuQuestionService zhiHuQuestionService;

    @GetMapping("/priority/{pageNum}/{pageSize}")
    public Result getQuestionsByPriority(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<ZhiHuQuestion> questions = zhiHuQuestionService.getQuestionsByPriority(pageNum, pageSize);
        return new Result(Code.ZHI_HU_GET_OK, questions);
    }
    @GetMapping("/userId/{userId}/{pageNum}/{pageSize}")
    public Result getQuestionsByUserId(@PathVariable Integer userId,@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<ZhiHuQuestion> questions = zhiHuQuestionService.getQuestionsByUserId(userId,pageNum, pageSize);
        return new Result(Code.ZHI_HU_GET_OK, questions);
    }

    @GetMapping("/rand/{pageNum}/{pageSize}")
    public Result getQuestionsByRand(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<ZhiHuQuestion> questions = zhiHuQuestionService.getQuestionsByRand(pageNum, pageSize);
        return new Result(Code.ZHI_HU_GET_OK, questions);
    }

    @PostMapping
    public Result createQuestion(@RequestBody ZhiHuQuestion question) {
        boolean flag = zhiHuQuestionService.createQuestion(question);
        return flag ?
                new Result(Code.ZHI_HU_SAVE_OK) :
                new Result(Code.ZHI_HU_SAVE_ERR);

    }

    @DeleteMapping("{id}")
    public Result delQuestionById(@PathVariable Integer id) {
        boolean flag = zhiHuQuestionService.delQuestionById(id);
        return flag ?
                new Result(Code.ZHI_HU_DEL_OK) :
                new Result(Code.ZHI_HU_DEL_ERR);

    }

    @PutMapping
    public Result updateQuestion(@RequestBody ZhiHuQuestion question) {
        boolean flag = zhiHuQuestionService.updateQuestion(question);
        return flag ?
                new Result(Code.ZHI_HU_UPDATE_OK) :
                new Result(Code.ZHI_HU_UPDATE_ERR);
    }


}
