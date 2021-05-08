package com.chenkai.exhibition.vo.info;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Kai Chen
 * @create 2021-05-09-4:29
 */
@Data
public class ExhibitionSetQueryVo {
    @ApiModelProperty(value = "展会名称")
    private String exName;

    @ApiModelProperty(value = "展会编号")
    private String exCode;
}
