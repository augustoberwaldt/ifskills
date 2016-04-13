insert into place(id, place_type, description, parent_place_id) values (1, 'Country', 'Brasil', null);
insert into place(id, place_type, description, parent_place_id) values (2, 'State', 'Rio Grande do Sul', 1);
insert into place(id, place_type, description, parent_place_id) values (3, 'State', 'Santa Catarina', 1);
insert into place(id, place_type, description, parent_place_id) values (4, 'State', 'Parana', 1);
insert into place(id, place_type, description, parent_place_id) values (5, 'City', 'Porto Alegre', 2);
insert into place(id, place_type, description, parent_place_id) values (6, 'City', 'Canoas', 2);

insert into address(id, street, number, complement, place_id) values (1, 'Maria Zélia Carneiro de Figueiredo', 870, null, 6);
insert into address(id, street, number, complement, place_id) values (2, 'Rua dos Andradas', 1951, 'apto 201', 5);

INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (1, '123@123.123', 'General User', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1, 'Software developer, with solid background in embedded applications. 
Strong analytical skills combined with experience in object oriented programming techniques. 
Compatible team player trough complete project cycles, testing, and final implementation. ');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (2, 'admin@123.123', 'General Admin', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2, 'WEB developer with experience in various types of projects , web sites , portals, enterprise systems , applications for Facebook , mobile apps ( Mobile) , e-commerce systems and multi- level systems.');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (3, 'trainer@123.123', 'General Trainer', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1, 'Solve and forward the calls to other teams.
Guide users in the use of ICT resources. 
Open and track called request services or incidents
Interact with other teams for the solution of user requests.');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, PRIVATE_PROFILE, address_id, description) VALUES (4, 'jrobaski@yahoo.com.br', 'José Ricardo Robaski', '$2a$10$g3JVotDZCxNZ8IdmDc5QkugSyyd0FNLNnzL5G1mMUcwn3ammWCM6m', null, 'TRUE', 1, 'Expert software developer in php');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (5, 'edsoncandio@gmail.com', 'Edson Giovani de Candio', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1, 'PhD in Software Engineering , Master in Applied Computing .');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (6, 'felipe.zoltowski', 'Felipe Zoltowski', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2, 'Analyst expert systems in project management using agile methods.');
INSERT INTO USER(ID, ACTIVE, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (7, 'FALSE', 'edward.ramos', 'Edward Ramos', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 1, 'Introduction Professor of computing , computer Master in education');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (8, 'alinegandolfi5@gmail.com', 'Aline Gandolfi', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2, 'Computer technician , enrolled in graduate degree in the field of Systems Analysis and Development');

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

insert  into article (id,  active, body , picture , posted_on , slug , teaser , title , user_id, private_article ) values (1, true,'hjhjfhjh jkojiojikj bhhgfhgh kjkijikjikjoi', null, sysdate,'Linguagens-JPA-JSF','hhhhh', 'JPA, JSF e Spring Tool Boot', 2, false) ;
insert  into article ( active, body , picture , posted_on , slug , teaser , title , user_id ) values (true,'This is body of the article', null, sysdate,'IDE-Spring-Tool','E teaser, também não sei o quer quer dizer?', 'Spring tool boot é o título',6) ;
insert  into article ( active, body , picture , posted_on , slug , teaser , title , user_id ) values (true,'This is body of the article This is body of the article', null, sysdate,'Artigo-sobre-Educação','Introdução Introdução Introdução Introdução Introdução Introdução Introdução Introdução Introdução', 'A educação em último lugar no país',1) ;
insert  into article ( active, body , picture , posted_on , slug , teaser , title , user_id ) values (true,'The English language is everywhere. The language of most of the Internet sites around the world is English. We are using this language to write our articles on this site, even though I am positive that English is not the first language of everybody using this website. It is not my first language, I come from Finland. I learned English at school. It is the most widely studied language in the world.
It is the language of media, medicine and business. Computing uses English as does the international airtraffic control. But is the spread of this language a good thing or a bad one, is the spread of one such a powerful language a disadvantage or an advantage?
This is a difficult question to answer. Academics in the field of linguistics have tried to find the best solution for this puzzle for decades now. One disadvantage which is often mentioned in this context is the fact that many languages have died because of the spread of English. Many still have lost a large number of speakers and are bound to be doomed in the near future. These are the disadvantages, and while they certainly seem gloomy, there are many advantages of having a global language.
', null, sysdate,'Artigo-sobre-Algo','A discussion about English language', 'English as a global language, a good or bad thing?',8) ;
insert into article ( active, body , picture , posted_on , slug , teaser , title , user_id ) values (true,'Alpha', null, sysdate,'Bravo','Charlie', 'Delta', 4);

insert into article_tags ( article_id, tags ) values(1, 'hjhhjjhhj, hsushshhs');
insert into article_tags ( article_id, tags ) values(2, 'IDE, SPRING TOOL');
insert into article_tags ( article_id, tags ) values(3, 'Artigo, Educacao');
insert into article_tags ( article_id, tags ) values(4, 'Artigo, English');
insert into article_tags ( article_id, tags ) values(5, 'Echo, Foxtrot');

insert into comment (content, posted_on, article_id, author_user_id) values ('Comment number one', sysdate,1 ,3);
insert into comment (content, posted_on, article_id, author_user_id) values ('Golf', sysdate, 5 , 4);