package com.chenkai.exhibition.model.info;

import com.chenkai.exhibition.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * HospitalSet
 * </p>
 *
 * @author qy
 */
@Data
@ApiModel(description = "展会设置")
@TableName("exhibit_info")
public class ExhibitionSet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    @TableField("exName")
    private String exName;

    @ApiModelProperty(value = "编号")
    @TableField("exCode")
    private String exCode;

    @ApiModelProperty(value = "地点")
    @TableField("exSite")
    private String exSite;

    @ApiModelProperty(value = "场馆")
    @TableField("exVenue")
    private String exVenue;

    @ApiModelProperty(value = "开始时间")
    @TableField("exST")
    private Data exST;

    @ApiModelProperty(value = "结束时间")
    @TableField("exET")
    private Data exET;

    @ApiModelProperty(value = "参展商要求")
    @TableField("exRequire")
    private String exRequire;


    @ApiModelProperty(value = "收费标准")
    @TableField("exRates")
    private String exRates;

    @ApiModelProperty(value = "食宿安排")
    @TableField("exRoom")
    private String exRoom;

    @ApiModelProperty(value = "会展组织机构")
    @TableField("exOrganization")
    private String exOrganization;


}
