CREATE TABLE mj_showcase_log (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        image_id             varchar(64)   NOT NULL COMMENT '唯一的id',
        raw_log              text          NOT NULL COMMENT '原始信息',
        store                int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否已存储',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COMMENT='showcase词汇';

