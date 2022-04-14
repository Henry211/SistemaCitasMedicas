/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ESCINF
 * Created: 13 abr. 2022
 */

CREATE DATABASE usuarios2;

use usuarios2;

--registro usuarios
create table usuario( nombre varchar(30) not null, password varchar(30) not null,
cedula varchar(10), tipo int, Primary Key (password));

insert into usuario(nombre,password,cedula, tipo) values("maria","mari7","111",1);
insert into usuario(nombre,password,cedula, tipo) values("lia","lia7","222",2);
insert into usuario(nombre,password,cedula, tipo) values("jose","jose7","333",1);


--registro administrador
create table administrador(cedula varchar(10) not null, password varchar(30) not null,
nombre varchar(30) not null,Primary Key (password));

insert into administrador(cedula,password,nombre) values("121","henr1","henry");
insert into administrador(cedula,password,nombre) values("111","car1","carla");
insert into administrador(cedula,password,nombre) values("343","man3","manuel");

--registro medico

create table medico(cedula varchar(10) not null, password varchar(30) not null,
nombre varchar(30) not null,Primary Key (password));


