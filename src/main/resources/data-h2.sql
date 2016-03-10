INSERT INTO USERS(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE) VALUES (1, '123@123.123', 'General User', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null);
INSERT INTO USERS(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE) VALUES (2, 'admin@123.123', 'General Admin', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null);
INSERT INTO USERS(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE) VALUES (3, 'admi3n@123.123', '333 Admin', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null);
INSERT INTO USERS(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE) VALUES (4, 'jrobaski@yahoo.com.br', 'José Ricardo Robaski', '$2a$10$g3JVotDZCxNZ8IdmDc5QkugSyyd0FNLNnzL5G1mMUcwn3ammWCM6m', null);
INSERT INTO USERS(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE) VALUES (5, 'edsoncandio@gmail.com', 'Edson Giovani de Candio', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null);

insert into roles(id, role) values (1, 'ROLE_USER');
insert into roles(id, role) values (2, 'ROLE_ADMIN');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (3, 1);
insert into users_roles (user_id, role_id) values (4, 1);
insert into users_roles (user_id, role_id) values (5, 1);

insert into item(id, name, description, active, date) values (1, 'Celular', 'Dispositivo de comunicação', true, sysdate);
insert into item(id, name, description, active, date) values (2, 'Caneta', 'Dispositivo de escrita manual a base de tinta', true, sysdate);
insert into item(id, name, description, active, date) values (3, 'Lápis', 'Dispositivo de escrita manual a base de grafite', false, sysdate);
insert into item(id, name, description, active, date) values (4, 'Cadeira', 'Assento para uma só pessoa, comumente portátil, com quatro pernas e espaldar, com ou sem braçose', true, sysdate);
insert into item(id, name, description, active, date) values (5, 'Software', 'É uma sequência de instruções escritas para serem interpretadas por um computador com o objetivo de executar tarefas específicas', true, sysdate);
insert into item(id, name, description, active, date) values (6, 'Hardware', 'É a parte física de um computador', true, sysdate);
insert into item(id, name, description, active, date) values (8, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (9, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (10, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (11, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (12, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (13, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (14, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (15, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (16, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (17, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);
insert into item(id, name, description, active, date) values (18, 'Blá Blá Blá', 'Blá Blá Blá', true, sysdate);

insert into Course (name, description, start_date, end_date, instructor_user_id) values ('Master in English', 'This is an English course', null, null, 1);
insert into Course (name, description, start_date, end_date, instructor_user_id) values ('Introduction to Oracle Database', 'Based on the most used database', null, null, 1);
insert into Course (name, description, start_date, end_date, instructor_user_id) values ('Scrum Master', 'This is an course for Scrum Masters', null, null, 1);
