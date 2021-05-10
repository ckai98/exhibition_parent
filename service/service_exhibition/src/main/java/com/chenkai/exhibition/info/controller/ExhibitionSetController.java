package com.chenkai.exhibition.info.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenkai.exhibition.common.exception.ExhibitionException;
import com.chenkai.exhibition.common.result.Result;
import com.chenkai.exhibition.info.service.ExhibitionSetService;
import com.chenkai.exhibition.model.hosp.HospitalSet;
import com.chenkai.exhibition.model.info.ExhibitionSet;
import com.chenkai.exhibition.vo.hosp.HospitalSetQueryVo;
import com.chenkai.exhibition.vo.info.ExhibitionSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kai Chen
 * @create 2021-05-09-2:50
 */

@Api(tags = "展会设置管理")
@RestController
@RequestMapping("admin/info/exhibitionSet")
@CrossOrigin
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

    //3 分页查询展会信息
    @PostMapping("findPageHospSet/{current}/{limit}")
    public Result findPageExhibitSet(@PathVariable long current,
                                     @PathVariable long limit,
                                     @RequestBody(required = false) ExhibitionSetQueryVo exhibitionSetQueryVo) {
        //RequestBody将传参改为json形式

        //创建page对象，传递当前页，每页记录数
        Page<ExhibitionSet> page = new Page<>(current,limit);
        //构建条件
        QueryWrapper<ExhibitionSet> wrapper = new QueryWrapper<>();
        String exName = exhibitionSetQueryVo.getExName();//医院名称
        String exCode = exhibitionSetQueryVo.getExCode();//医院编号
        if(!StringUtils.isEmpty(exName)) {
            wrapper.like("exName",exhibitionSetQueryVo.getExName());
        }
        if(!StringUtils.isEmpty(exCode)) {
            wrapper.eq("exCode",exhibitionSetQueryVo.getExCode());
        }

        //调用方法实现分页查询
        IPage<ExhibitionSet> pageExhibitSet = exhibitionSetService.page(page, wrapper);

        //返回结果
        return Result.ok(pageExhibitSet);

    }

    //4 添加展会设置
    @PostMapping("saveExhibitionSet")
    public Result saveExhibitionSet(ExhibitionSet exhibitionSet){
        //@RequestBody 使用此标签无法成功添加，问题待解决。

        boolean save = exhibitionSetService.save(exhibitionSet);
        if (save){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //5 根据ID获取展会信息
    @GetMapping("getExhibitionSet/{id}")
    public Result getExhibitionSet(@PathVariable Long id){
//        try {
//            //模拟异常
//            int a = 1/0;
//        }catch (Exception e) {
//            throw new ExhibitionException("失败",201);//返回状态码201
//        }
        ExhibitionSet exhibitionSet = exhibitionSetService.getById(id);
        return Result.ok(exhibitionSet);
    }


    //6 修改展会设置
    @PostMapping("updateExhibitionSet")
    public Result updateExhibitionSet(ExhibitionSet exhibitionSet) {
        //@RequestBody 使用此标签无法成功添加，问题待解决。
        boolean flag = exhibitionSetService.updateById(exhibitionSet);
        if(flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //7 批量删除展会信息
    @DeleteMapping("batchRemove")
    public Result batchRemoveExhibitionSet(@RequestBody List<Long> idList) {
        //@RequestBody 使用此标签无法成功添加，问题待解决。
        exhibitionSetService.removeByIds(idList);
        return Result.ok();
    }
}
