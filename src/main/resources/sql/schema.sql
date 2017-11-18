create table `sys_user` (
	`id` int not null auto_increment comment '主键',
	`username` varchar(30) not null comment '用户名',
	`nickname` varchar(20) not null comment '昵称',
	`password` varchar(50) not null comment '密码',
	`id_card` varchar(18) comment '身份证',
	`real_name` varchar(20) comment '真实姓名',
	`sex` tinyint(1) not null default 1 comment '性别 0:女 1:男',
	`address` varchar(50) comment '地址',
	`mobile` varchar(11) not null comment '电话',
	`email` varchar(20) comment '邮箱',
	`locked` tinyint(1) not null default 0 comment '0:未锁 1:已锁',
	`image` varchar(50) comment '头像',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	primary key (id),
    key idx_create_time (create_time)
) engine = INNODB default charset = utf8 comment '系统用户表';

create table `sys_role` (
    `id` int not null auto_increment comment '主键',
    `name` varchar(20) not null comment '角色名称',
    `description` varchar(50) comment '',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `user_id` int not null comment '创建人id',
    primary key (id),
    foreign key (user_id) references `sys_user` (id),
    key idx_create_time (create_time)
) engine = INNODB default charset = utf8 comment '系统权限表';

create table `sys_user_role` (
	`id` int not null auto_increment comment '主键',
	`user_id` int not null comment '用户id',
	`role_id` int not null comment '角色id',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
	primary key (id),
	foreign key (user_id) references `sys_user` (id),
	foreign key (role_id) references `sys_role` (id),
    key idx_create_time (create_time)
) engine = INNODB default charset = utf8 comment '用户角色表';

create table `sys_resource` (
	`id` int not null auto_increment comment '主键',
	`name` varchar(20) not null comment '资源名称',
	`url` varchar(20) not null comment '路径',
	`permission` varchar(255) comment '权限',
	`parent_id` int not null default 0 comment '父id, 根目录为0',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`sort` tinyint not null default 50 comment '排序',
	`description` varchar(100) comment '描述',
	primary key (id),
	key idx_create_time (create_time)
) engine = INNODB default charset = utf8 comment '系统资源表';

create table `sys_role_resource` (
	`id` int not null auto_increment comment '主键',
	`role_id` int not null comment '角色id',
	`resource_id` int not null comment '资源id',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	primary key (id),
	foreign key (role_id) references `sys_role` (id),
	foreign key (resource_id) references `sys_resource` (id),
	key idx_create_time (create_time)
) engine = INNODB default charset = utf8 comment '系统资源表';