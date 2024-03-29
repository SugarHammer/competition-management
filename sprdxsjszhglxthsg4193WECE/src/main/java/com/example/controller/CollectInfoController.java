package com.example.controller;

import com.example.common.Result;
import com.example.entity.CollectInfo;
import com.example.service.CollectInfoService;
import com.example.vo.CollectInfoVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/collectInfo")
public class CollectInfoController {
    @Resource
    private CollectInfoService collectInfoService;

    @PostMapping
    public Result<CollectInfo> add(@RequestBody CollectInfo collectInfo, HttpServletRequest request) {
//        CollectInfo collectInfo1 = collectInfoService.findByShoucangmingcheng(collectInfo.getShoucangmingcheng());
//        if (collectInfo1 != null){
//            return Result.error("201","商品已经收藏，请勿重复收藏");
//        }

        if(collectInfo.getUserId() == null){
            return Result.error("201","请先登录");
        } else{
            System.out.println(collectInfo.toString());
//        Account user = (Account) request.getSession().getAttribute("user");
//        collectInfo.setUserId(user.getId());
            collectInfoService.add(collectInfo);
            return Result.success(collectInfo);
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        collectInfoService.delete(id);
        return Result.success();
    }

    @GetMapping("/findAll/{userId}/{level}")
    public Result<List<CollectInfo>> all(@PathVariable("userId") Long userId, @PathVariable("level") String level) {
        return Result.success(collectInfoService.findAll(userId, level));
    }

    @GetMapping("/page/{userId}/{level}")
    public Result<PageInfo<CollectInfoVo>> page(@PathVariable Long userId, @PathVariable String level,
                                                      @RequestParam(defaultValue = "1") Integer pageNum,
                                                      @RequestParam(defaultValue = "5") Integer pageSize,
                                                @RequestParam String name,
                                                      HttpServletRequest request) {
        return Result.success(collectInfoService.findPage(userId,level, pageNum, pageSize, request,name));
    }
}
