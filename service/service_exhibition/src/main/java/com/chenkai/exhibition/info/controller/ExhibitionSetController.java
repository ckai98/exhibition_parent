package com.chenkai.exhibition.info.controller;

import com.chenkai.exhibition.common.result.Result;
import com.chenkai.exhibition.info.service.ExhibitionSetService;
import com.chenkai.exhibition.model.info.ExhibitionSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kai Chen
 * @create 2021-05-09-2:50
 */

@Api(tags = "展会设置管理")
@RestController
@RequestMapping("admin/info/exhibitionSet")
public class ExhibitionSetController {

    @Autowired
    private ExhibitionSetService exhibitionSetService;


    // http://localhost:8201/admin/info/exhibitionSet/findAll

    //1 查询展会信息表所有信息
    @ApiOperation(value = "获取所有展会信息")
    @GetMapping("findAll")
    public Result findAllExhibitionSet() {
        //调用service的方法
        List<ExhibitionSet> list = exhibitionSetService.list();
        return Result.ok(list);
    }


    //2 逻辑删除展会设置
    @ApiOperation(value = "逻辑删除指定展会信息")
    @DeleteMapping("{id}")
    public Result removeExhibitSet(@PathVariable Long id) {
        boolean flag = exhibitionSetService.removeById(id);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }


}
