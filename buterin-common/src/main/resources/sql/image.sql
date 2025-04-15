CREATE TABLE normal_image (
    id             bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    type           varchar(32)   NOT NULL COMMENT '图片的类型',
    target_id      bigint(20)    unsigned DEFAULT 0 '图片所属对象id，如果有',
    format         varchar(32)   NOT NULL COMMENT '图片格式',
    path           varchar(512)  NOT NULL DEFAULT '' COMMENT '路径（如果是动态图片）',
    url            varchar(512)  NOT NULL DEFAULT '' COMMENT 'url地址（如果是静态图片）',
    info           varchar(512)  NOT NULL DEFAULT '{}' COMMENT '图片信息',
    ext            varchar(1024) NOT NULL DEFAULT '{}' COMMENT '扩展信息',
    created_at     bigint(32)    NOT NULL COMMENT '创建时间',
    updated_at     bigint(32)    NOT NULL COMMENT '更新时间',
    is_deleted     int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='模型图片存储表';