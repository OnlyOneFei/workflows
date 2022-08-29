package com.fy.workflows.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类文件描述：流程实例节点审批人中间表
 *
 * @author Fei_Yu
 * @date 2022/8/29 17:32
 */
@Data
@TableName(value = "flow_instance_node_audit_user")
public class FlowInstanceNodeAuditUser {
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
     * 流程节点ID
     */
    @TableField(value = "flow_node_id")
    private Integer flowNodeId;

    /**
     * 审核人
     */
    @TableField(value = "audit_user_id")
    private Integer auditUserId;

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