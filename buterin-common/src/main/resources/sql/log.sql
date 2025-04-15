CREATE TABLE web_log (
        id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
        user_id              bigint(20)    unsigned NULL COMMENT '用户id',
        ip                   varchar(32)   NULL COMMENT '用户ip',
        duration             bigint(20)    unsigned NOT NULL COMMENT '时长',
        method               varchar(32)   NULL COMMENT '方法',
        base_path            varchar(256)  NULL COMMENT '网址',
        uri                  varchar(512)  NULL COMMENT '路径',
        description          varchar(256)  NULL COMMENT '接口描述',
        parameter            varchar(512)  NULL COMMENT '请求参数',
        created_at           bigint(32)    NOT NULL,
        updated_at           bigint(32)    NOT NULL,
        is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='web请求日志';