CREATE TABLE question (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        user_id              bigint(20)    unsigned NOT NULL COMMENT '作者id',
        title                varchar(512)  NOT NULL COMMENT '问题标题',
        content              text          NOT NULL COMMENT '内容',
        src_content          text          NOT NULL COMMENT '内容源码',
        tags                 varchar(256)  NOT NULL COMMENT '标签',
        view_cnt             bigint(20)    NOT NULL DEFAULT 0 COMMENT '阅读量',
        answer_cnt           bigint(20)    NOT NULL DEFAULT 0 COMMENT '回答数',
        support_cnt          bigint(20)    NOT NULL DEFAULT 0 COMMENT '支持数',
        status               varchar(64)   NOT NULL DEFAULT 'DEFAULT' COMMENT '问题状态',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        INDEX idx_user_id (user_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='问题信息表';

CREATE FULLTEXT INDEX sec_idx ON question (title,content,tags) WITH PARSER ngram;


CREATE TABLE answer (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        question_id          bigint(20)    unsigned NOT NULL COMMENT '问题id',
        user_id              bigint(20)    unsigned NOT NULL COMMENT '用户id',
        content              text          NOT NULL COMMENT '内容',
        src_content          text          NOT NULL COMMENT '内容源码',
        approved             int(1)        NOT NULL DEFAULT 0 COMMENT '是否被作者采纳',
        agree_cnt            bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '赞同数',
        disagree_cnt         bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '不赞同数',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        INDEX idx_question_id (question_id),
        INDEX idx_user_id (user_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='问题回答表';