insert into place(id, place_type, description, parent_place_id) values (1, 'Country', 'Brasil', null);
insert into place(id, place_type, description, parent_place_id) values (2, 'State', 'Rio Grande do Sul', 1);
insert into place(id, place_type, description, parent_place_id) values (3, 'State', 'Santa Catarina', 1);
insert into place(id, place_type, description, parent_place_id) values (4, 'State', 'Parana', 1);
insert into place(id, place_type, description, parent_place_id) values (5, 'City', 'Porto Alegre', 2);
insert into place(id, place_type, description, parent_place_id) values (6, 'City', 'Canoas', 2);

insert into address(id, street, number, complement, place_id) values (1, 'Maria Zélia Carneiro de Figueiredo', 870, null, 6);
insert into address(id, street, number, complement, place_id) values (2, 'Rua dos Andradas', 1951, 'apto 201', 5);

INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (1, '123@123.123', 'General User', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (2, 'admin@123.123', 'General Admin', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (3, 'trainer@123.123', 'General Trainer', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (4, 'jrobaski@yahoo.com.br', 'José Ricardo Robaski', '$2a$10$g3JVotDZCxNZ8IdmDc5QkugSyyd0FNLNnzL5G1mMUcwn3ammWCM6m', null, 1);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (5, 'edsoncandio@gmail.com', 'Edson Giovani de Candio', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (6, 'felipe.zoltowski', 'Felipe Zoltowski', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (7, 'edward.ramos', 'Edward Ramos', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1);
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id) VALUES (8, 'aline.gandolfi', 'Aline Gandolfi', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2);

insert into roles(id, role) values (1, 'ROLE_USER');
insert into roles(id, role) values (2, 'ROLE_ADMIN');
insert into roles(id, role) values (3, 'ROLE_TRAINER');

insert into users_roles (user_id, role_id) values (1, 1);
insert into users_roles (user_id, role_id) values (2, 2);
insert into users_roles (user_id, role_id) values (3, 3);
insert into users_roles (user_id, role_id) values (4, 1);
insert into users_roles (user_id, role_id) values (5, 1);
insert into users_roles (user_id, role_id) values (6, 2);
insert into users_roles (user_id, role_id) values (6, 3);
insert into users_roles (user_id, role_id) values (7, 2);
insert into users_roles (user_id, role_id) values (7, 3);
insert into users_roles (user_id, role_id) values (8, 2);
insert into users_roles (user_id, role_id) values (8, 3);

insert into item(id, name, description, active, date) values (1, 'Celular', 'Dispositivo de comunicação', true, sysdate);
insert into item(id, name, description, active, date) values (2, 'Caneta', 'Dispositivo de escrita manual a base de tinta', true, sysdate);
insert into item(id, name, description, active, date) values (3, 'Lápis', 'Dispositivo de escrita manual a base de grafite', false, sysdate);
insert into item(id, name, description, active, date) values (4, 'Cadeira', 'Assento para uma só pessoa, comumente portátil, com quatro pernas e espaldar, com ou sem braçose', true, sysdate);
insert into item(id, name, description, active, date) values (5, 'Software', 'É uma sequência de instruções escritas para serem interpretadas por um computador com o objetivo de executar tarefas específicas', true, sysdate);
insert into item(id, name, description, active, date) values (6, 'Hardware', 'É a parte física de um computador', true, sysdate);

insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (1, 'Master in English',800 , 'This is an English course', '2016-03-01', '2016-12-15', 2);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (2, 'Introduction to Oracle Database', 120, 'Based on the most used database', '2016-02-01', '2016-02-28', 2);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (3, 'Basic Excel', 80, 'Excel for Beginners', '2016-03-01', '2016-03-31', 2);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (4, 'Scrum Master', 460, 'This is an course for Scrum Masters', '2016-04-01', '2016-04-30', 6);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (5, 'Advanced Excel 1', 100, 'Graphics', '2016-04-01', '2016-04-30', 6);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (6, 'Advanced Excel 2', 100, 'Formulas', '2016-05-01', '2016-05-31', 6);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (7, 'Basic Word', 60, 'Word for Beginners', '2016-06-01', '2016-06-30', 7);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (8, 'Advanced Word 1', 100, 'Layouts', '2016-07-01', '2016-07-31', 7);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (9, 'Advanced Word 2', 100, 'ABNT', '2016-08-01', '2016-08-31', 7);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (10, 'Basic PowerPoint', 80, 'PowerPoint for Beginners', '2016-09-01', '2016-09-30', 8);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (11, 'Advanced PowerPoint 1', 100, 'Music and Video', '2016-10-01', '2016-10-31', 8);
insert into Course (id, name, workload, description, start_date, end_date, instructor_user_id) values (12, 'Advanced PowerPoint 2', 100, 'PDF', '2016-11-01', '2016-11-30', 8);

insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 1);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (2, 2);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 3);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 4);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 5);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 6);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 7);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 12);

insert  into article ( active, body , comment_id , picture , posted_on , slug , teaser , title , user_id ) values (true,'hjhjfhjh jkojiojikj bhhgfhgh kjkijikjikjoi', null, null, sysdate,'mmmmmm','hhhhh', 'kkkkk', 2) ;
insert  into article ( active, body , comment_id , picture , posted_on , slug , teaser , title , user_id ) values (true,'This is body of the article', null, null, sysdate,'O que seria slug???? Claro que não é lesma não é????','E teaser, também não sei o quer quer dizer?', 'Spring tool boot é o título',3) ;