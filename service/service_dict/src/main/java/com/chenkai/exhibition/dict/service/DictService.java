package com.chenkai.exhibition.dict.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenkai.exhibition.model.dict.Dict;
import com.chenkai.exhibition.model.info.ExhibitionSet;

import java.util.List;

/**
 * @author Kai Chen
 * @create 2021-05-09-2:46
 */
public interface DictService extends IService<Dict> {
    //根据数据id查询子数据列表
    List<Dict> findChlidData(Long id);

}
