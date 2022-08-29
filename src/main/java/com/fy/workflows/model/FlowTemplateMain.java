package com.fy.workflows.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类文件描述：流程模板主表
 *
 * @author Fei_Yu
 * @date 2022/8/29 17:32
 */
@Data
@TableName(value = "flow_template_main")
public class FlowTemplateMain {
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 模板key
     */
    @TableField(value = "workflow_key")
    private String workflowKey;

    /**
     * 模板名称
     */
    @TableField(value = "template_name")
    private String templateName;

    /**
     * 模板状态(0草稿,1启用,2禁用)
     */
    @TableField(value = "template_state")
    private Integer templateState;

    /**
     * 有效标识
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}