CREATE TABLE user (
    id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    user_name            varchar(128)  NOT NULL UNIQUE COMMENT '用户名',
    phone_number         varchar(128)  NOT NULL UNIQUE COMMENT '手机号码',
    password             varchar(256)  NOT NULL COMMENT '登录密码',
    salt                 varchar(64)   NOT NULL COMMENT '密码盐值',
    role                 varchar(64)   NOT NULL COMMENT '用户角色',
    info                 varchar(1024) NULL COMMENT '用户其他信息',
    locked               int(1)        unsigned NOT NULL DEFAULT 0 COMMENT '是否被锁定',
    created_at           bigint(32)    NOT NULL,
    updated_at           bigint(32)    NOT NULL,
    is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

alter table user add column points bigint(32) unsigned NOT NULL DEFAULT 0 COMMENT '用户算力积分' after info;


insert into user(user_name, phone_number, password, salt, role, info, locked, created_at, updated_at, is_deleted)
values ('aigccafe2023', '17306586054', 'c1bc2d093293af5491e64b9dd779eb2f', 'boowin','admin', '{"nickname":"某一热心网友","avatarUrl":""}',0,1684056338,1684056338,0);

CREATE TABLE sms_code (
    id                   bigint(20)    unsigned NOT NULL AUTO_INCREMENT,
    phone_number         varchar(128)  UNIQUE NOT NULL COMMENT '注册手机',
    code                 varchar(64)   NOT NULL COMMENT '数字验证码',
    expired_at           bigint(32)    NOT NULL COMMENT '过期时间',
    created_at           bigint(32)    NOT NULL,
    updated_at           bigint(32)    NOT NULL,
    is_deleted           int(1)        unsigned NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='短信验证码记录';