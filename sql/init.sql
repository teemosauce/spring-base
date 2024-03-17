create table if not exists pandora.user
(
    id         bigint                                 not null
        primary key,
    name       varchar(255) default ''                not null,
    email      varchar(255) default ''                not null,
    createTime datetime     default CURRENT_TIMESTAMP not null,
    updateTime datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);


