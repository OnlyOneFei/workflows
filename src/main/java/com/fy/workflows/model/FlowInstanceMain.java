package com.fy.workflows.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类文件描述：流程实例主表
 *
 * @author Fei_Yu
 * @date 2022/8/29 17:32
 */
@Data
@TableName(value = "flow_instance_main")
public class FlowInstanceMain {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 模板key
     */
    @TableField(value = "workflow_key")
    private String workflowKey;

    /**
     * 组织租户ID
     */
    @TableField(value = "tenant_org_id")
    private String tenantOrgId;

    /**
     * 业务唯一key
     */
    @TableField(value = "process_key")
    private String processKey;

    /**
     * 流程状态(审核中,通过,驳回)
     */
    @TableField(value = "flow_state")
    private Integer flowState;

    /**
     * 当前审核人
     */
    @TableField(value = "current_audit_user_id")
    private Integer currentAuditUserId;

    /**
     * 全局参数
     */
    @TableField(value = "param_map_json")
    private String paramMapJson;

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