CREATE DATABASE demo;
USE demo;

create table users (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	email varchar(220) NOT NULL,
	country varchar(120),
	PRIMARY KEY (id)
);

desc users;

select * from users;


ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';




