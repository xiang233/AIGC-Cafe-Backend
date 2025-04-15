CREATE TABLE comment (
    id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    user_id             bigint(20)    unsigned NOT NULL COMMENT '评论者的id',
    comment_type        varchar(32)   NOT NULL COMMENT '评论类型，父评论或者子评论等',
    target_id           bigint(20)    unsigned NOT NULL COMMENT '评论对象ID',
    target_type         varchar(32)   NOT NULL COMMENT '评论对象类型',
    parent_user_id      bigint(20)    DEFAULT NULL COMMENT '父评论的id',
    parent_comment_id   bigint(20)    DEFAULT NULL COMMENT '父评论ID, 用于跟帖',
    content             text          NOT NULL COMMENT '评论内容',
    likes_count         bigint(20)    NOT NULL DEFAULT 0 COMMENT '喜欢数',
    created_at          bigint(32)    NOT NULL,
    updated_at          bigint(32)    NOT NULL,
    is_deleted          int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id),
    INDEX idx_user_id (user_id),
    INDEX idx_target_id_target_type (target_id, target_type),
    INDEX idx_parent_comment_id (parent_comment_id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';


CREATE TABLE simple_interaction (
    id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    interaction_type    varchar(32)   NOT NULL COMMENT '交互类型',
    user_id             bigint(20)    unsigned NOT NULL COMMENT '用户id',
    target_type         varchar(32)   NOT NULL COMMENT '交互对象',
    target_id           bigint(20)    unsigned NOT NULL COMMENT '交互对象ID',
    value               double        NOT NULL DEFAULT 0.0 COMMENT '数值，一些交互行为可能会附带数值，比如打分',
    ext                 varchar(512)  NOT NULL DEFAULT '{}' COMMENT '缺省字段，用于其他一些复杂行为',
    created_at          bigint(32)    NOT NULL,
    updated_at          bigint(32)    NOT NULL,
    is_deleted          int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id),
    UNIQUE KEY idx_type_user_id_target_id_target_type (interaction_type, user_id, target_type, target_id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='用户普通交互记录表';

CREATE TABLE interaction_stat (
    id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    target_type         varchar(32)   NOT NULL COMMENT '交互对象',
    target_id           bigint(20)    unsigned NOT NULL COMMENT '交互对象ID',
    like_count          bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '喜欢总量',
    store_count         bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '收藏总量',
    comment_count       bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '评论总数',
    download_count      bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '下载总量',
    score_count         bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '打分总量',
    score_sum           double        unsigned NOT NULL DEFAULT 0.0 COMMENT '打分总分',
    agree_count         bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '赞同数目',
    disagree_count      bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '不赞同数目',
    support_count       bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '支持数目',
    un_support_count    bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '不支持数目',
    view_count          bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '浏览数目',
    created_at          bigint(32)    NOT NULL,
    updated_at          bigint(32)    NOT NULL,
    is_deleted          int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id),
    INDEX idx_target_id_target_type (target_type, target_id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='用户普通交互记录表';