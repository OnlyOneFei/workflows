package com.fy.workflows.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类文件描述：流程实例节点状态结果表
 *
 * @author Fei_Yu
 * @date 2022/8/29 17:32
 */
@Data
@TableName(value = "flow_instance_node_detail")
public class FlowInstanceNodeDetail {
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
     * 流程节点ID
     */
    @TableField(value = "flow_node_id")
    private Integer flowNodeId;

    /**
     * 节点类型(1审核2分派3审核并分派)
     */
    @TableField(value = "flow_node_type")
    private Integer flowNodeType;

    /**
     * 审核人
     */
    @TableField(value = "flow_audit_user_id")
    private Integer flowAuditUserId;

    /**
     * 节点状态(0待审核1通过2驳回)
     */
    @TableField(value = "flow_audit_state")
    private Integer flowAuditState;

    /**
     * 批注
     */
    @TableField(value = "flow_audit_comment")
    private String flowAuditComment;

    /**
     * 审批时间
     */
    @TableField(value = "flow_audit_time")
    private LocalDateTime flowAuditTime;

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
}