create table sakila.actor
(
  actor_id    smallint(5) unsigned auto_increment
    primary key,
  first_name  varchar(45)                         not null,
  last_name   varchar(45)                         not null,
  last_update timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
)
  charset = utf8;
