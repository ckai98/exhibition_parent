package com.chenkai.exhibition.dict.controller;

import com.chenkai.exhibition.common.result.Result;
import com.chenkai.exhibition.dict.service.DictService;
import com.chenkai.exhibition.model.dict.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kai Chen
 * @create 2021-05-12-0:32
 */
@Api(tags = "数据字典接口")
@RestController
@RequestMapping("admin/dict")
@CrossOrigin
public class DictController {
    @Autowired
    private DictService dictService;

    //根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return Result.ok(list);
    }

}
