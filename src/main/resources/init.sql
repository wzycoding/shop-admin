create table if not exists user (
  id bigint PRIMARY key auto_increment comment 'id',
  username varchar(20) not null comment '用户名',
  password varchar(20) not null comment '密码',
  avater varchar(20) not null comment '头像',
  nickname varchar(20) not null comment '昵称',
  phone varchar(11) not null comment '手机号码',
  create_time datetime not null comment '创建时间',
  last_login_time datetime not null comment '最后登录时间',
  `delete` INT not null comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';


create table if not exists menu (
  id bigint primary key auto_increment comment 'id',
  auth_name varchar(20) not null default '' comment '菜单名称',
  parent_id int not null default 0 comment '父id',
  level_index int not null default 0 comment '层级索引',
  path varchar(100) not null default '' comment '菜单指向路径',
  create_time datetime not null comment '创建时间',
  updated_time datetime not null comment '修改时间',
  `delete` int not null default 0 comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8m64 COMMENT = '菜单表';


create table if not exists role (
  id bigint primary key auto_increment comment 'id',
  name varchar(20) not null comment '角色名称',
  type int not null comment '角色类型',
  seq int not null comment '优先级',
  remark varchar(200) not null default '' comment '角色备注',
  create_time datetime not null comment '创建时间',
  updated_time datetime not null comment '修改时间',
  `delete` int not null default 0 comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8m64 COMMENT = '角色表';


create table if not exists role_user (
  id bigint primary key auto_increment comment 'id',
  user_id bigint not null comment '用户id',
  role_id bigint not null comment '角色id',
  create_time datetime not null comment '创建时间',
  updated_time datetime not null comment '修改时间',
  `delete` int not null default 0 comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8m64 COMMENT = '用户角色表';

create table if not exists acl (
  id bigint primary key auto_increment comment 'id',
  name varchar(20) not null comment '权限名称',
  path varchar(100) not null comment '路径',
  level int not null comment '权限等级',
  create_time datetime not null comment '创建时间',
  updated_time datetime not null comment '修改时间',
  `delete` int not null default 0 comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8m64 COMMENT = '权限表';


create table if not exists acl_role (
  id bigint primary key auto_increment comment 'id',
  role_id bigint not null comment '角色id',
  acl_id bigint not null comment '权限id',
  create_time datetime not null comment '创建时间',
  updated_time datetime not null comment '修改时间',
  `delete` int not null default 0 comment '删除标记'
)ENGINE = InnoDB
  DEFAULT CHARSET = utf8m64 COMMENT = '角色权限表';


