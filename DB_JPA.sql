CREATE DATABASE BOOKSTORE;
USE BOOKSTORE;
CREATE TABLE Product(
Id int primary key auto_increment,
NameProduct nvarchar(100),
Price Float, 
Quantity int,
Discription nvarchar(150)
);
select * from Category;
CREATE TABLE Category(
Id int primary key auto_increment,
NameCategory nvarchar(100),
Location nvarchar(100),
Product_id int, 
foreign key (Product_id) references Product(Id)
);
select * from Product;
SELECT * FROM Category;
