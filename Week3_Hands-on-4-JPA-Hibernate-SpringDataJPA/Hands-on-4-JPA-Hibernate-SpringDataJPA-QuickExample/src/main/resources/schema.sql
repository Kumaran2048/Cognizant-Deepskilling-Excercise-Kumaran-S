create schema if not exists ormlearn;
use ormlearn;
create table if not exists country (
  co_code varchar(2) not null,
  co_name varchar(50),
  primary key (co_code)
);
