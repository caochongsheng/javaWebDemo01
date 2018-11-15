CREATE TABLE ikan_admin_user (
  id      SMALLINT UNSIGNED   NOT NULL AUTO_INCREMENT
  COMMENT '管理员id',
  name    VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '管理员姓名',
  pwd     VARCHAR(32)         NOT NULL DEFAULT ''
  COMMENT '管理员密码',
  PRIMARY KEY (id),
  UNIQUE KEY (name)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '后台-管理员';

-- 权限表 3-2
CREATE TABLE ikan_admin_auth (
  id         SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '权限id',
  name       VARCHAR(32)       NOT NULL DEFAULT ''
  COMMENT '权限名称',
  pid        SMALLINT UNSIGNED NOT NULL DEFAULT '0'
  COMMENT '父id',
  controler  VARCHAR(32)       NOT NULL DEFAULT ''
  COMMENT '控制器',
  action     VARCHAR(32)       NOT NULL DEFAULT ''
  COMMENT '操作方法',
  path       VARCHAR(150)      NOT NULL DEFAULT ''
  COMMENT '全路径:c-a',
  auth_level TINYINT UNSIGNED  NOT NULL DEFAULT 0
  COMMENT '级别,基本:0, 顶级:1, 次顶级:2, 次次顶级:3',
  PRIMARY KEY (id)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '后台-权限表';

-- 角色表 3-3
CREATE TABLE ikan_admin_role (
  id           SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT '角色id',
  name         VARCHAR(32)       NOT NULL DEFAULT ''
  COMMENT '角色名称',
  role_desc    VARCHAR(32)       NOT NULL DEFAULT ''
  COMMENT '角色描述',
  PRIMARY KEY (id),
  UNIQUE KEY (name)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '后台-角色表';

-- 用户角色表
CREATE TABLE ikan_admin_user_role (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  user_id INT          NOT NULL
  COMMENT '用户ID',
  role_id INT          NOT NULL
  COMMENT '角色ID',
  PRIMARY KEY (id),
  KEY user_id(user_id),
  KEY role_id(role_id)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '后台-用户角色表';

-- 角色权限表
CREATE TABLE ikan_admin_role_auth (
  id      INT UNSIGNED NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  role_id INT UNSIGNED NOT NULL
  COMMENT '角色ID',
  auth_id INT UNSIGNED NOT NULL
  COMMENT '权限ID',
  PRIMARY KEY (id),
  KEY role_id(role_id),
  KEY auth_id(auth_id)
)
  ENGINE = innoDB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1
  COMMENT '后台-角色权限表';