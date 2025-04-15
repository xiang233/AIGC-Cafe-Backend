CREATE TABLE journey_session (
        id             bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        user_id        bigint(20)    unsigned NOT NULL COMMENT '用户id',
        session_name   varchar(512)  NOT NULL DEFAULT '新的创作' COMMENT '会话名称',
        created_at     bigint(32)    NOT NULL COMMENT '创建时间',
        updated_at     bigint(32)    NOT NULL COMMENT '更新时间',
        is_deleted     int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='journey会话表';

CREATE TABLE journey_short_url (
        id             bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        short_code     varchar(512)  NOT NULL COMMENT '链接码',
        url            varchar(512)  NOT NULL COMMENT '原始链接',
        created_at     bigint(32)    NOT NULL COMMENT '创建时间',
        updated_at     bigint(32)    NOT NULL COMMENT '更新时间',
        is_deleted     int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='journey短链接表';

CREATE TABLE journey_task (
        id                      bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        session_id              bigint(20)    unsigned NOT NULL COMMENT '所属会话ID',
        user_id                 bigint(20)    unsigned NOT NULL COMMENT '用户id',
        task_type               varchar(64)   NOT NULL COMMENT '任务类型',
        refer_image_list        varchar(1024) NOT NULL DEFAULT '' COMMENT '参考图片路径列表，逗号分隔，上传图片时才有值',
        image_index             int           unsigned NULL COMMENT '多张进行选择时的序号,UV任务时才有值',
        prompt                  varchar(1024) NOT NULL DEFAULT '' COMMENT '提示词，UV任务等是没有提示词的',
        father_task_id          bigint(20)    unsigned NULL COMMENT '父任务ID，UV等任务才会有父任务',
        ori_task_id             varchar(128)  NOT NULL COMMENT '源站任务id',
        dimensions              varchar(128)  NULL COMMENT '当为BLEND任务时，才可能有的选项值',
        status                  varchar(64)   NOT NULL DEFAULT 'SUBMITTED' COMMENT '任务状态',
        progress                varchar(64)   NOT NULL DEFAULT '0%' COMMENT '任务进度',
        fail_reason             varchar(512)  NOT NULL DEFAULT '' COMMENT '失败原因',
        d_image_url             varchar(256)  NOT NULL DEFAULT '' COMMENT 'd站的拼图链接',
        mid_image_url           varchar(256)  NOT NULL DEFAULT '' COMMENT 'm站的拼图链接',
        mid_sub_image_list      varchar(1024) NOT NULL DEFAULT '' COMMENT 'm站子图链接列表，U任务为空',
        image_path              varchar(256)  NOT NULL DEFAULT '' COMMENT '转存的展示小图路径,一般为512宽度',
        raw_image_path          varchar(256)  NOT NULL DEFAULT '' COMMENT '转存的展示原图路径',
        sub_image_path_list     varchar(1024) NOT NULL DEFAULT '' COMMENT '转存的子图路径，U任务为空',
        raw_sub_image_path_list varchar(1024) NOT NULL DEFAULT '' COMMENT '转存原始子图路径，U任务为空',
        submit_time             bigint(32)    NOT NULL DEFAULT 0 COMMENT '提交时间',
        start_time              bigint(32)    NOT NULL DEFAULT 0 COMMENT '开始时间',
        finish_time             bigint(32)    NOT NULL DEFAULT 0 COMMENT '完成时间',
        task_resp               varchar(2048) NULL COMMENT '任务返回信息',
        created_at              bigint(32)    NOT NULL COMMENT '创建时间',
        updated_at              bigint(32)    NOT NULL COMMENT '更新时间',
        is_deleted              int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
        INDEX idx_session_user (session_id, user_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='journey会话中的任务';

CREATE TABLE journey_member (
        id             bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        user_id        bigint(20)    unsigned NOT NULL COMMENT '用户ID',
        member_type    varchar(64)   NOT NULL COMMENT '会员类型',
        fast_times     int           unsigned NOT NULL COMMENT '快速生成剩余次数',
        expired_at     bigint(32)    NOT NULL COMMENT '会员权益截止时间',
        created_at     bigint(32)    NOT NULL COMMENT '创建时间',
        updated_at     bigint(32)    NOT NULL COMMENT '更新时间',
        is_deleted     int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
        INDEX idx_user_id (user_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='journey会员表';

CREATE TABLE journey_task_log (
        id                 bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        task_id            bigint(20)    unsigned NOT NULL COMMENT '任务id',
        error_log          longtext NOT NULL COMMENT '错误日志',
        created_at     bigint(32)    NOT NULL COMMENT '创建时间',
        updated_at     bigint(32)    NOT NULL COMMENT '更新时间',
        is_deleted     int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='journey任务异常日志';