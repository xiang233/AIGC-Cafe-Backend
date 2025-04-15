CREATE TABLE journey_gallery_image (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        source               varchar(64)   NOT NULL COMMENT '图片来源',
        image_id             varchar(64)   NOT NULL COMMENT '用于标识图片的唯一id',
        prompt               text          NOT NULL COMMENT '完成的提示词',
        image_path           varchar(512)  NOT NULL COMMENT '合适大小的图片路径',
        raw_image_path       varchar(512)  NOT NULL COMMENT '原图片存储路径',
        mid_image_url        varchar(512)  NOT NULL COMMENT '可访问的源短链接地址（备用）',
        price                double        NOT NULL DEFAULT 0.0 COMMENT '价格',
        view_cnt             int           NOT NULL DEFAULT 0 COMMENT '浏览次数',
        status               varchar(64)   NOT NULL DEFAULT 'ONLINE' COMMENT '状态',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='journey关键词';

alter table journey_gallery_image add column status varchar(64) NOT NULL DEFAULT 'ONLINE' COMMENT '状态' after view_cnt;
alter table journey_gallery_image add column cn_prompt text NULL COMMENT '中文提示词' after prompt;

CREATE FULLTEXT INDEX sec_idx ON journey_gallery_image (prompt) WITH PARSER ngram;
select prompt from journey_gallery_image where MATCH(prompt) AGAINST('工业设计') ORDER BY view_cnt LIMIT 0,20;


CREATE TABLE stable_gallery_image (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        source               varchar(64)   NOT NULL COMMENT '图片来源',
        image_id             varchar(64)   NOT NULL COMMENT '用于标识图片的唯一id',
        model_id             bigint(20)    unsigned NULL COMMENT '模型id',
        model_name           varchar(128)  NULL COMMENT '模型名称',
        version_id           bigint(20)    unsigned NULL COMMENT '版本id',
        version_name         varchar(128)  NULL COMMENT '版本名称',
        meta                 text          NOT NULL COMMENT '提示词信息',
        raw_url              varchar(512)  NOT NULL COMMENT '源图片地址',
        raw_image_path       varchar(512)  NOT NULL COMMENT '原图片转储路径',
        image_path           varchar(512)  NOT NULL COMMENT '适合展示的转储路径',
        author_info          text          NULL COMMENT '源作者信息',
        price                double        NOT NULL DEFAULT 0.0 COMMENT '价格',
        view_cnt             int           NOT NULL DEFAULT 0 COMMENT '浏览次数',
        status               varchar(64)   NOT NULL DEFAULT 'ONLINE' COMMENT '状态',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='sd关键词';

alter table stable_gallery_image add column status varchar(64) NOT NULL DEFAULT 'ONLINE' COMMENT '状态' after view_cnt;
alter table stable_gallery_image add column cn_meta text NULL COMMENT '中文提示词信息' after meta;

CREATE FULLTEXT INDEX sec_idx ON stable_gallery_image(meta) WITH PARSER ngram;
select meta from stable_gallery_image where MATCH(meta) AGAINST('工业设计') ORDER BY view_cnt LIMIT 0,20;

CREATE TABLE prompt_tag (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        tag                  varchar(512)  NOT NULL COMMENT '标签',
        cn_tag               varchar(512)   NOT NULL COMMENT '标签中文翻译',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        UNIQUE (tag),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='标签集';












