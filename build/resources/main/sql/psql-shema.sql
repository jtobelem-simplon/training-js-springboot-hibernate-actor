create table sakila.actor
(
  actor_id    bigint not null
    constraint actor_pkey
    primary key,
  first_name  varchar(255),
  last_name   varchar(255),
  last_update date
);
