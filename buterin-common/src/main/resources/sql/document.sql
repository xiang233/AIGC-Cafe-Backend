CREATE TABLE document (
     id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
     user_id             bigint(20)    unsigned NOT NULL COMMENT '文档创建者',
     document_type       varchar(64)   NOT NULL COMMENT '文档类型',
     document_name       varchar(64)   NOT NULL COMMENT '文档名称',
     profile             varchar(512)  NOT NULL COMMENT '文档简介',
     cover_path          varchar(256)  NOT NULL COMMENT '封面图片',
     article_id_list     varchar(512)  NULL COMMENT '文档内一级文章有序列表',
     created_at          bigint(32)    NOT NULL,
     updated_at          bigint(32)    NOT NULL,
     is_deleted          int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
     PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='文档表';

CREATE TABLE article (
     id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
     user_id             bigint(20)    unsigned NOT NULL COMMENT '文章作者',
     document_id         bigint(20)    unsigned NOT NULL COMMENT '所属文档id',
     parent_id           bigint(20)    unsigned NOT NULL DEFAULT 0 COMMENT '父文章id',
     title               VARCHAR(256)  NOT NULL COMMENT '文章标题',
     content             text          NOT NULL COMMENT 'md5源',
     html                text          NOT NULL COMMENT 'html源',
     child_id_list       VARCHAR(512)  NULL COMMENT '子文章有序列表',
     tags                VARCHAR(512)  NOT NULL COMMENT '标签',
     created_at          bigint(32)    NOT NULL,
     updated_at          bigint(32)    NOT NULL,
     is_deleted          INT(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
     PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';


CREATE TABLE outer_article (
     id                  bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
     raw_url             VARCHAR(512)  NOT NULL COMMENT '源地址',
     user_id             bigint(20)    unsigned NOT NULL COMMENT '更新作者',
     title               VARCHAR(256)  NOT NULL COMMENT '文章标题',
     cover_path          VARCHAR(256)  NOT NULL COMMENT '封面图片',
     brief               VARCHAR(1024) NOT NULL COMMENT '摘要',
     raw_html            longtext      NOT NULL COMMENT '原始页面html',
     content             longtext      NOT NULL COMMENT 'md5源',
     html                longtext      NOT NULL COMMENT 'html源',
     tags                VARCHAR(512)  NOT NULL DEFAULT '' COMMENT '标签',
     status              VARCHAR(32)   NOT NULL DEFAULT 'REVIEW' COMMENT '状态',
     created_at          bigint(32)    NOT NULL,
     updated_at          bigint(32)    NOT NULL,
     is_deleted          INT(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
     UNIQUE (raw_url),
     PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='外部文章表';



