/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jvillafrancacarmo
 * Created: Jun 28, 2023
 */

insert into producto(nombre, marca, precio) values ('Xbox', 'Microsoft', 11300);

insert into users(username, password, enabled) values ('user', '$2a$10$45NIgC1jVO9/jT2/HOyxmu5By3zNUd.vEltew1vhcGCaFfp1ykga2', 1);
insert into users(username, password, enabled) values ('admin', '$2a$10$Kl9mwRVgwviqHKXNEmCdwu7XPHbfZtWjDjtkvsLnvNnj.6.Q5Hhla', 1);

insert into authorities(authority, username) values ('ROLE_USER', 'user');
insert into authorities(authority, username) values ('ROLE_ADMIN', 'admin');



