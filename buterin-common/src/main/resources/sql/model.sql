CREATE TABLE model_detail (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        platform             varchar(128)  NOT NULL COMMENT '平台',
        ori_model_id         bigint(20)    unsigned NOT NULL COMMENT '模型id',
        model_name           varchar(256)  NOT NULL COMMENT '模型名称',
        description          text          NOT NULL COMMENT '模型描述',
        nsfw                 int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否nsfw',
        status               varchar(64)   NOT NULL COMMENT '状态',
        author_name          varchar(64)   NOT NULL COMMENT '作者名字',
        download_cnt         bigint(20)    unsigned NOT NULL COMMENT '下载次数',
        type                 varchar(64)   NOT NULL COMMENT '类型',
        checkpoint_type       varchar(64)   NOT NULL COMMENT 'ck细分类型',
        tags                 varchar(512)  NOT NULL COMMENT '标签列表',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        UNIQUE (platform, ori_model_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='模型信息表';

alter table model_detail add column user_id bigint(20) unsigned NOT NULL COMMENT '上传者用户id' after tags;
alter table model_detail add column manual_tags varchar(512)  NOT NULL COMMENT '人工标签' after user_id;
alter table model_detail add column cover_path varchar(512) NOT NULL COMMENT '封面地址' after manual_tags;
alter table model_detail change column checkpointType checkpoint_type varchar(512) NOT NULL COMMENT 'ck类型';
alter table model_detail add column chn_model_name varchar(512)  NULL COMMENT '模型中文名称' after model_name;
alter table model_detail add column chn_description text NULL COMMENT '模型中文说明' after description;
alter table model_detail add column base_model varchar(32) NOT NULL DEFAULT 'Other' COMMENT '底模' after download_cnt;

--频道搜索
CREATE FULLTEXT INDEX chn_sec_idx ON model_detail (manual_tags) WITH PARSER ngram;
select model_name,manual_tags from model_detail where MATCH(manual_tags) AGAINST('工业设计');
select model_name,manual_tags from model_detail where MATCH(manual_tags) AGAINST('效果' IN BOOLEAN MODE) ORDER BY download_cnt LIMIT 0,20;

--全局搜索
CREATE FULLTEXT INDEX sec_idx ON model_detail (manual_tags,model_name,author_name) WITH PARSER ngram;
CREATE FULLTEXT INDEX sec_2_idx ON model_detail (manual_tags,model_name,chn_model_name,author_name) WITH PARSER ngram;

select model_name,manual_tags,author_name from model_detail where MATCH(manual_tags,model_name,author_name) AGAINST('工业设计') ORDER BY download_cnt LIMIT 0,20;


CREATE TABLE model_version (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        platform             varchar(128)  NOT NULL COMMENT '平台',
        model_id             bigint(20)    unsigned NOT NULL COMMENT '模型id',
        ori_model_id         bigint(20)    unsigned NOT NULL COMMENT '原模型id',
        ori_version_id       bigint(20)    unsigned NOT NULL COMMENT '原版本id',
        version_name         varchar(256)  NOT NULL COMMENT '版本名称',
        description          text          NULL COMMENT '版本描述',
        base_model           varchar(128)  NOT NULL COMMENT '模型框架版本',
        status               varchar(64)   NOT NULL COMMENT '状态',
        download_cnt         bigint(20)    unsigned NOT NULL COMMENT '下载次数',
        last_updated_at      varchar(128)  NOT NULL COMMENT '最新更新时间',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        UNIQUE (platform, ori_model_id,ori_version_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='模型版本表';


CREATE TABLE model_version_file (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        platform             varchar(128)  NOT NULL COMMENT '平台',
        model_id             bigint(20)    unsigned NOT NULL COMMENT '模型id',
        model_name           varchar(128)  NOT NULL COMMENT '模型名称',
        version_id           bigint(20)    unsigned NOT NULL COMMENT '版本id',
        version_name         varchar(128)  NOT NULL COMMENT '版本名称',
        ori_model_id         bigint(20)    unsigned NOT NULL COMMENT '模型id',
        ori_version_id       bigint(20)    unsigned NOT NULL COMMENT '原版本id',
        ori_file_id          bigint(20)    unsigned NOT NULL COMMENT '原文件id',
        sizeKB               double        NOT NULL COMMENT '大小（KB）',
        type                 varchar(64)   NOT NULL COMMENT '文件类型',
        name                 varchar(512)  NOT NULL COMMENT '文件名称',
        metadata             varchar(1024) NOT NULL COMMENT '文件元信息',
        url                  varchar(512)  NOT NULL COMMENT '下载地址',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        UNIQUE (platform, ori_model_id,ori_version_id,ori_file_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='文件表';

CREATE TABLE model_version_image (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        platform             varchar(128)  NOT NULL COMMENT '平台',
        model_id             bigint(20)    unsigned NOT NULL COMMENT '模型id',
        model_name           varchar(128)  NOT NULL COMMENT '模型名称',
        version_id           bigint(20)    unsigned NOT NULL COMMENT '版本id',
        version_name         varchar(128)  NOT NULL COMMENT '版本名称',
        ori_model_id         bigint(20)    unsigned NOT NULL COMMENT '原模型id',
        ori_version_id       bigint(20)    unsigned NOT NULL COMMENT '原版本id',
        ori_image_id         bigint(20)    unsigned NOT NULL COMMENT '原图片id',
        url                  varchar(512)  NOT NULL COMMENT '源图片地址',
        nsfw                 int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否nsfw',
        width                integer       unsigned NOT NULL DEFAULT 0 COMMENT '宽',
        height               integer       unsigned NOT NULL DEFAULT 0 COMMENT '长',
        meta                 longtext      NOT NULL COMMENT '生成信息',
        mimeType             varchar(128)  NOT NULL COMMENT '图片格式',
        author_info          text          NOT NULL COMMENT '作者信息',
        raw_path             varchar(256)  NOT NULL COMMENT 'oss原图转储路径',
        normal_path          varchar(256)  NOT NULL COMMENT '展示版本存储路径',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        UNIQUE (platform, ori_model_id,ori_version_id,ori_image_id),
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='版本图片表';

alter table model_version_image add column user_id bigint(20) unsigned NOT NULL COMMENT '上传者用户id' after tags;
