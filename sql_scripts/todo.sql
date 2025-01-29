DROP DATABASE IF EXISTS todolist;
CREATE DATABASE todoList;

       CREATE TABLE todo(
           id BIGINT AUTO_INCREMENET,
           title varchar(256) not null ,
           completed TINYINT(1),
           PRIMARY KEY(id)
       );