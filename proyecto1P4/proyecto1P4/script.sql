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

create table medico(nombre varchar(30) not null, cedula varchar(10) not null,
clave varchar(30) not null,costo_consulta double,Primary Key (clave));

insert into medico(nombre,cedula,clave, costo_consulta) values("samuel","345","samudoc",1200);
insert into medico(nombre,cedula,clave, costo_consulta) values("antony","555","ant1",3000);


--registro especialidad
create table especialidad(id int not null,nombre varchar(30) not null,
Primary Key (id));

insert into especialidad(id,nombre) values(1,"pediatra");

--tabla cita falta meter el usuario 

create table cita(id int not null, estado varchar(30) not null, fecha date,
Primary Key (id));

--registro ciudad
create table ciudad(id int not null, provincia varchar(30) not null,
canton varchar(30) not null,distrito varchar(30) ,Primary Key (id));

insert into ciudad(id,provincia,canton,distrito) values(1,"san jose","acosta","mora");
insert into ciudad(id,provincia,canton,distrito) values(2,"san jose","desamparados","san miguel");



