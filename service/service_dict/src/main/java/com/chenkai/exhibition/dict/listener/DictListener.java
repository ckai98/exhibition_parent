package com.chenkai.exhibition.dict.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.chenkai.exhibition.dict.mapper.DictMapper;
import com.chenkai.exhibition.model.dict.Dict;
import com.chenkai.exhibition.vo.dict.DictEeVo;
import org.springframework.beans.BeanUtils;

/**
 * @author Kai Chen
 * @create 2021-05-13-1:29
 */
public class DictListener extends AnalysisEventListener<DictEeVo> {
    private DictMapper dictMapper;
    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //一行一行读取
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        //调用方法添加数据库
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);
        dictMapper.insert(dict);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
