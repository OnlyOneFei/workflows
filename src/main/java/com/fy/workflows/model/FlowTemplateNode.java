package com.fy.workflows.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 类文件描述：流程模板节点表
 *
 * @author Fei_Yu
 * @date 2022/8/29 17:32
 */
@Data
@TableName(value = "flow_template_node")
public class FlowTemplateNode {
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
     * 上级节点ID
     */
    @TableField(value = "parent_flow_node_id")
    private Integer parentFlowNodeId;

    /**
     * 审核节点名称
     */
    @TableField(value = "flow_node_name")
    private String flowNodeName;

    /**
     * 节点类型(1审核2分派3审核并分派)
     */
    @TableField(value = "flow_node_type")
    private Integer flowNodeType;

    /**
     * 审核条件code
     */
    @TableField(value = "condition_code")
    private String conditionCode;

    /**
     * 事件监听器class全路径
     */
    @TableField(value = "event_listener")
    private String eventListener;

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
     * 创建人ID
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 修改更新人ID
     */
    @TableField(value = "update_user_id")
    private Integer updateUserId;
}