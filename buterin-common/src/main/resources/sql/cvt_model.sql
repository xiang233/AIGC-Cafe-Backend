CREATE TABLE cvt_model_detect (
    id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    model_id             bigint(20)    unsigned NOT NULL UNIQUE COMMENT '模型id',
    model_name           varchar(512)  NOT NULL COMMENT '模型名称',
    model_type           varchar(128)  NOT NULL COMMENT '模型类型',
    checkpoint_type      varchar(128)  NOT NULL COMMENT '针对ck的细分类型',
    request_info         varchar(512)  NOT NULL COMMENT '查询信息',
    rank_info            varchar(1024) NOT NULL COMMENT '排名数据',
    cover_image_data     varchar(1024) NOT NULL COMMENT '封面图片信息',
    last_version_at      varchar(256)  NOT NULL COMMENT '最新版本更新时间',
    detail_update        int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '最新商详是否更新',
    created_at           bigint(32)    NOT NULL,
    updated_at           bigint(32)    NOT NULL,
    is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='c站模型状态监控表';


CREATE TABLE cvt_model_detail (
    id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    model_id             bigint(20)    unsigned NOT NULL UNIQUE COMMENT '模型id',
    model_name           varchar(256)  NOT NULL COMMENT '模型名称',
    description          text          NOT NULL COMMENT '模型描述',
    nsfw                 int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否nsfw',
    type                 varchar(64)   NOT NULL COMMENT '类型',
    checkpointType       varchar(64)   NOT NULL COMMENT 'ck细分类型',
    user_info            varchar(512)  NOT NULL COMMENT '作者信息',
    model_version_list   longtext      NOT NULL COMMENT '下辖模型版本信息',
    rank_info            text          NOT NULL COMMENT '排名数据',
    tags_info            text          NOT NULL COMMENT '标签信息',
    last_updated_at      varchar(128)  NOT NULL COMMENT '最新版本更新时间',
    version_image_update int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '版本图片是否更新',
    post_image_update    int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '投递图片是否更新',
    merged               int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '模型文件是否更新',
    need_check_update    int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否需要检查更新',
    created_at           bigint(32)    NOT NULL,
    updated_at           bigint(32)    NOT NULL,
    is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='c站模型详情页';

alter table cvt_model_detail change column version_file_update merged int(1) unsigned NOT NULL DEFAULT 0 COMMENT '是否合并入库';


CREATE TABLE cvt_model_version_image (
    id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    model_id             bigint(20)    unsigned NOT NULL COMMENT '模型id',
    model_version_id     bigint(20)    unsigned NOT NULL COMMENT '版本id',
    post_id              bigint(20)    unsigned NOT NULL COMMENT '发表的id',
    image_id             bigint(20)    unsigned NOT NULL UNIQUE COMMENT '源站图片id',
    url                  varchar(512)  NOT NULL COMMENT '图片地址',
    nsfw                 int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否nsfw',
    width                integer       unsigned NOT NULL DEFAULT 0 COMMENT '宽',
    height               integer       unsigned NOT NULL DEFAULT 0 COMMENT '长',
    meta                 longtext      NOT NULL COMMENT '生成信息',
    mimeType             varchar(128)  NOT NULL COMMENT '图片格式',
    user_info            text          NOT NULL COMMENT '作者信息',
    created_at           bigint(32)    NOT NULL,
    updated_at           bigint(32)    NOT NULL,
    is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='c站模型版本图片信息';