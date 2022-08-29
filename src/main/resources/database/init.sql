drop table if exists flow_instance_main;

drop table if exists flow_instance_node_audit_user;

drop table if exists flow_instance_node_detail;

drop table if exists flow_template_main;

drop table if exists flow_template_node;

/*==============================================================*/
/* Table: flow_instance_main                                    */
/*==============================================================*/
create table flow_instance_main
(
    id                    int          not null comment '主键ID',
    workflow_key          varchar(255) not null comment '模板key',
    tenant_org_id         varchar(255) not null comment '组织租户ID',
    process_key           varchar(255) not null comment '业务唯一key',
    flow_state            tinyint      not null comment '流程状态(审核中,通过,驳回)',
    current_audit_user_id int          not null comment '当前审核人',
    param_map_json        json comment '全局参数',
    del_flag              tinyint      not null default 0 comment '有效标识',
    create_time           timestamp    not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time           timestamp    not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table flow_instance_main
    comment '流程实例主表';

/*==============================================================*/
/* Table: flow_instance_node_audit_user                         */
/*==============================================================*/
create table flow_instance_node_audit_user
(
    id            int          not null comment '主键ID',
    workflow_key  varchar(255) not null comment '模板key',
    tenant_org_id varchar(255) not null comment '组织租户ID',
    flow_node_id  int          not null comment '流程节点ID',
    audit_user_id int          not null comment '审核人',
    del_flag      tinyint      not null default 0 comment '有效标识',
    create_time   timestamp    not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time   timestamp    not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table flow_instance_node_audit_user
    comment '流程实例节点审批人中间表';

/*==============================================================*/
/* Table: flow_instance_node_detail                             */
/*==============================================================*/
create table flow_instance_node_detail
(
    id                 int          not null comment '主键ID',
    workflow_key       varchar(255) not null comment '模板key',
    tenant_org_id      varchar(255) not null comment '组织租户ID',
    process_key        varchar(255) not null comment '业务唯一key',
    flow_node_id       int          not null comment '流程节点ID',
    flow_node_type     tinyint      not null comment '节点类型(1审核2分派3审核并分派)',
    flow_audit_user_id int          not null comment '审核人',
    flow_audit_state   tinyint      not null default 0 comment '节点状态(0待审核1通过2驳回)',
    flow_audit_comment varchar(255) not null comment '批注',
    flow_audit_time    timestamp comment '审批时间',
    del_flag           tinyint      not null default 0 comment '有效标识',
    create_time        timestamp    not null default CURRENT_TIMESTAMP comment '创建时间',
    primary key (id)
);

alter table flow_instance_node_detail
    comment '流程实例节点状态结果表';

/*==============================================================*/
/* Table: flow_template_main                                    */
/*==============================================================*/
create table flow_template_main
(
    id             int          not null comment '主键ID',
    workflow_key   varchar(255) not null comment '模板key',
    template_name  varchar(255) not null default '' comment '模板名称',
    template_state tinyint      not null default 0 comment '模板状态(0草稿,1启用,2禁用)',
    del_flag       tinyint      not null default 0 comment '有效标识',
    create_time    timestamp    not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time    timestamp    not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    primary key (id)
);

alter table flow_template_main
    comment '流程模板主表';

/*==============================================================*/
/* Index: unique_index_workflow_key                             */
/*==============================================================*/
create unique index unique_index_workflow_key on flow_template_main
    (
     workflow_key
        );

/*==============================================================*/
/* Table: flow_template_node                                    */
/*==============================================================*/
create table flow_template_node
(
    id                  int          not null comment '主键ID',
    workflow_key        varchar(255) not null comment '模板key',
    parent_flow_node_id int          not null default 0 comment '上级节点ID',
    flow_node_name      varchar(255) not null default '' comment '审核节点名称',
    flow_node_type      tinyint      not null comment '节点类型(1审核2分派3审核并分派)',
    condition_code      varchar(255) not null default '' comment '审核条件code',
    event_listener      varchar(255) comment '事件监听器class全路径',
    del_flag            tinyint      not null default 0 comment '有效标识',
    create_time         timestamp    not null default CURRENT_TIMESTAMP comment '创建时间',
    create_user_id      int comment '创建人ID',
    update_time         timestamp    not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
    update_user_id      int comment '修改更新人ID',
    primary key (id)
);

alter table flow_template_node
    comment '流程模板节点表';

