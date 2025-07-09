show databases;
create database RetailDB;
use RetailDB;
create table products(
productId int primary key,
name varchar(100),
category varchar(50),
price double,
stockQuantity int
);
