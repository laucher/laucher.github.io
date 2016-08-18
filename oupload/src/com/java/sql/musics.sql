
drop database if exists music; 

create database music;

use music;

create table if not exists musics(
	id varchar(64) primary key,
	name varchar(200) not null,
	path varchar(1024)
);