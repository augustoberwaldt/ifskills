-- PLACE
insert into place(id, place_type, description, parent_place_id) values (1, 'Country', 'Brasil', null);
insert into place(id, place_type, description, parent_place_id) values (2, 'State', 'Rio Grande do Sul', 1);
insert into place(id, place_type, description, parent_place_id) values (3, 'State', 'Santa Catarina', 1);
insert into place(id, place_type, description, parent_place_id) values (4, 'State', 'Parana', 1);
insert into place(id, place_type, description, parent_place_id) values (5, 'City', 'Porto Alegre', 2);
insert into place(id, place_type, description, parent_place_id) values (6, 'City', 'Canoas', 2);

-- ADDRESS
insert into address(id, street, number, complement, place_id) values (1, 'Maria Zélia Carneiro de Figueiredo', 870, null, 6);
insert into address(id, street, number, complement, place_id) values (2, 'Rua dos Andradas', 1951, 'apto 201', 5);
insert into address(id, street, number, complement, place_id) values (3, 'Rua República', 1234, 'apto 505', 6);

-- USER
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
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (9, 'labifrs2016.1@gmail.com', 'Lab IFRS', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2, 'Computer technician , enrolled in graduate degree in the field of Systems Analysis and Development');
INSERT INTO USER(ID, EMAIL, FULL_NAME, PASSWORD, PICTURE, address_id, description) VALUES (10, 'lucianes2009@gmail.com', 'Luciane da Silva', '$2a$10$cy42kPdxwRGcrx02umaL3O7f7xUKXQtugjXLrM9/DNay.D.WNK3HC', null, 2, 'Computer technician , enrolled in graduate degree in the field of Systems Analysis and Development');

-- ROLES
insert into roles(id, role) values (1, 'ROLE_USER');
insert into roles(id, role) values (2, 'ROLE_ADMIN');
insert into roles(id, role) values (3, 'ROLE_TRAINER');

-- USER_ROLES
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
insert into users_roles (user_id, role_id) values (9, 2);

-- ITEM
insert into item(id, name, description, active, date) values (1, 'Celular', 'Dispositivo de comunicação', true, sysdate);
insert into item(id, name, description, active, date) values (2, 'Caneta', 'Dispositivo de escrita manual a base de tinta', true, sysdate);
insert into item(id, name, description, active, date) values (3, 'Lápis', 'Dispositivo de escrita manual a base de grafite', false, sysdate);
insert into item(id, name, description, active, date) values (4, 'Cadeira', 'Assento para uma só pessoa, comumente portátil, com quatro pernas e espaldar, com ou sem braçose', true, sysdate);
insert into item(id, name, description, active, date) values (5, 'Software', 'É uma sequência de instruções escritas para serem interpretadas por um computador com o objetivo de executar tarefas específicas', true, sysdate);
insert into item(id, name, description, active, date) values (6, 'Hardware', 'É a parte física de um computador', true, sysdate);

-- COURSE
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

-- COURSE_ATTENDEES
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 1);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (2, 2);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 3);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 4);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 5);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 6);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 7);
insert into COURSE_ATTENDEES (ATTENDEE_USER_ID ,COURSE_ID ) values (1, 12);

-- JOB_AD
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('Vaga TI','Vale-refeição e Vale transporte', 'Informática TI',  'rh@bol.com.br', 'Nível hierárquico: Operacional, Regime de contratação de tipo Efetivo – CLT Jornada Período Integral', 'Ensino Superior',  'Escolaridade Mínima: Ensino Superior Inglês (Intermediário - Requerido) Programação: C#, JavaScript, jQuery, PHP', 10, 2, 'Approved');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('TI Manager','Meal ticket and Health Insurance', 'IT',  'rh.it@gmail.com', 'IT MANAGER - Maintains information technology strategies by managing staff; researching and implementing technological strategic solutions.', 'Graduation in IT area',  'Knowledge of English and French; Data Center Management, Developing Budgets, Coordination; Java, JavaScript, Spring, SCRUM, SQL', 8, 3, 'Waiting');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('Java developer','Health Insurance and Place for Meal', 'IT',  'rh.it@gmail.com', 'JAVA DEVELOPER - Creates user information solutions by developing, implementing, and maintaining Java based components and interfaces.', 'Graduation in progress in IT area',  'Knowledge of English; Java, Java Applets, Web Programming Skills, Teamwork, Verbal Communication, Software Debugging, Spring, SCRUM, SQL', 8, 2, 'Waiting');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('Marketing Assistant','Transportation Vouchers', 'Marketing',  'rh.marketing@gmail.com', 'MARKETING ASSISTANT - Supports marketing operations by compiling, formatting, and reporting information and materials.', 'Graduation in progress',  'Written Communication, Organization, Statistical Analysis, General Math, Microsoft Office, Self-Development, Financial Skills', 1, 1, 'Waiting');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('IT Technician','Meal ticket and Transportation Vouchers', 'IT',  'rh.it@gmail.com', 'IT TECHNICIAN - Serves customers by installing and servicing systems and products.', 'Technical Course in IT area', 'Knowledge of English (basic level); Electronics Troubleshooting, Equipment Maintenance, Reporting Skills, Confidentiality, Quality Focus', 9, 1, 'Approved');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('DBA Architect','Meal ticket and Transportation Vouchers', 'IT',  'rh.it@gmail.com', 'DATABASE ARCHITECT - Maintains database by determining structural requirements; developing and installing solutions.', 'Graduation in IT area', 'Knowledge of English and Spanish; Database Design, Data Maintenance, Database Security, Database Management, Requirements Analysis, Teamwork; Oracle SQL, PostgreSQL, MySQL', 8, 2, 'Waiting');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('DBA Manager','Meal ticket and Transportation Vouchers', 'IT',  'it123@gmail.com', 'DATABASE MANAGER - Manage database information and transactions.', 'Graduation in IT area', 'Knowledge of English and Spanish; Database Design, Data Maintenance, Database Security, Database Management, Requirements Analysis, Teamwork; Oracle SQL, PostgreSQL, MySQL', 9, 1, 'Approved');
insert into job_Ad(TITLE, BENEFITS, BUSINESS_AREA, CONTACT_INFO, DESCRIPTION, EDUCATION_LEVEL_REQUIRED, REQUIREMENTS, EMPLOYER_ID, LOCATION_ID, STATUS ) values ('Computer Engineer','Meal ticket and Transportation Vouchers', 'IT',  'rh@bol.com.br', 'COMPUTER ENGINEER - Develops new hardware and recovery older machines.', 'Graduation in Computer Science Area', 'Knowledge of English and Spanish; Database Design, Data Maintenance, Database Security, Database Management, Requirements Analysis, Teamwork; Oracle SQL, PostgreSQL, MySQL', 7, 2, 'Approved');

-- JOB_AD_TAGS
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(1, 'Informática, Ti');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(2, 'Manager, IT');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(3, 'Developer, Java, IT');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(4, 'Marketing, Supports');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(5, 'Technician, Developer, Products');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(6, 'Database, Architect');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(7, 'Database, Manager');
insert into JOB_AD_TAGS  (JOB_AD_ID , tags ) values(8, 'Computer, Engineer');

-- POSTS
insert into document(id, body, posted_on, user_id) values (1, 'Collaborative development of a fictitious system in class software development laboratory.', sysdate, 1);
insert into post (id, title, subject, is_public) values (1, 'Welcome to IFSkills', 'Informática TI', true);
insert into post_tags (post_id, tags) values (1, 'Tics, Educação');
insert into rank (id, rank, document_id) values (1, 2.5, 1);

insert into document(id, body, posted_on, user_id) values (3, 'leo et posuere dolor dolor ipsum interdum rhoncus volutpat saepe tincidunt justo', sysdate, 2);
insert into post (id, title, subject, is_public) values (3, 'About Article', 'Mineração de Dados', true);
insert into post_tags (post_id, tags ) values(3, 'Inteligência, BI');
insert into rank (id, rank, document_id) values (3, 5, 3);

insert into document(id, body, posted_on, user_id) values (4, 'leo et posuere dolor dolor ipsum interdum rhoncus volutpat saepe tincidunt justo', sysdate, 3);
insert into post (id, title, subject, is_public) values (4, 'About Jobs', 'Spring Boot', true);
insert into post_tags (post_id, tags ) values(4, 'IDE, ferramenta');
insert into rank (id, rank, document_id) values (4, 4.2, 4);

insert into document(id, body, posted_on, user_id) values (5, 'leo et posuere dolor dolor ipsum interdum rhoncus volutpat saepe tincidunt justo', sysdate, 4);
insert into post (id, title,subject, is_public) values (5, 'About Courses', 'Persistência Java', false);
insert into post_tags (post_id, tags) values(5, 'Liguagem, BD');
insert into rank (id, rank, document_id) values (5, 3.2, 5);

insert into document(id, body, posted_on, user_id) values (6, 'leo et posuere dolor dolor ipsum interdum rhoncus volutpat saepe tincidunt justo', sysdate, 5);
insert into post (id, title,subject, is_public) values (6, 'About Items', 'E-commerce', false);
insert into post_tags (post_id, tags) values (6, 'Comércio, Online');
insert into rank (id, rank, document_id) values (6, 2.8, 6);

-- ARTICLES
insert into document(id, body, posted_on, user_id) values (2, 'Biological science these days is all about Big Data. Whether it’s in the form of DNA sequences, photomicrographs, or mass spectra, researchers increasingly need to collect, integrate, manipulate, and interpret enormous pools of information.
For many biologists, that can be pretty intimidating. Traditional training programs tend to focus on scientific fundamentals and experimentation, not computer programming and statistics. As a result, when many researchers find themselves confronted by massive data sets, they have no idea how to tackle them.
There’s no shortage of readily available computational tools to help—many free of charge—but these too can be overwhelming for the uninitiated. Typically, users must interact with these programs through command-line wizardry, rather than through user-friendly graphical interfaces. And doing so often requires a deep knowledge of the underlying algorithms.
The upshot is that researchers working with big data inevitably have to write at least a little code to handle the information in a reproducible and well-documented way. Yet they must be cautious. It’s easy to make a mistake, and if researchers aren’t careful, they can end up compromising the data itself.', sysdate, 2);
insert into article (id, active, picture, slug, teaser, title, private_article) values (2, true, null, 'get-program', 'DIY tips for adding coding to your analysis arsenal', 'Get With the Program', false) ;
insert into article_tags (article_id, tags) values (2, 'Tag1 Article2, Tag2 Article2');

insert into document(id, body, posted_on, user_id) values (7, 'Standing out in a crowd—and particularly, the crowded world of social media—may become a little easier as MIT researchers develop a clever way to tweak profile photos to play up a person’s most memorable facial features. Aditya Khosla and others at MIT have found a way to make photographs of faces more memorable or more forgettable, opening new doors in the understanding of memory.
The process was detailed in work presented at the International Conference on Computer Vision in Sydney in December 2013 and earned Khosla a Facebook Graduate Fellowship for further research. According to the researchers, such “feature tuning”—which could be extended from memorability to other qualities, like confidence or trustworthiness—has the potential to change everything from one’s profile photo on Facebook to online dating to political campaigns and advertising strategies.', sysdate, 2);
insert into article (id, active, picture, slug, teaser, title, private_article) values (7, true, null, 'face-remember', 'Researchers show that a tuning algorithm can make one’s profile photo more memorable', 'A Face to Remember', false) ;
insert into article_tags (article_id, tags) values (7, 'IDE, SPRING TOOL');

insert into document(id, body, posted_on, user_id) values (8, 'One of the biggest challenges for developing artificial intelligence is programming computers to understand natural language. But, when IBM programmers fed super computer Watson the Urban Dictionary—an online repository for slang—in an attempt to school it in current lingo, they inadvertently taught it to swear indiscriminately, according to a report in Fortune magazine.', sysdate, 3);
insert into article (id, active, picture, slug, teaser, title, private_article) values (8, true, null, 'watson’s-potty-mouth', 'IBM programmers had to clean up the super computer’s language after it learned profanity on the Internet', 'Watson’s Potty Mouth', false) ;
insert into article_tags (article_id, tags ) values (8, 'Artigo, Educacao');

insert into document(id, body, posted_on, user_id) values (9, 'The English language is everywhere. The language of most of the Internet sites around the world is English. We are using this language to write our articles on this site, even though I am positive that English is not the first language of everybody using this website. It is not my first language, I come from Finland. I learned English at school. It is the most widely studied language in the world.
It is the language of media, medicine and business. Computing uses English as does the international airtraffic control. But is the spread of this language a good thing or a bad one, is the spread of one such a powerful language a disadvantage or an advantage?
This is a difficult question to answer. Academics in the field of linguistics have tried to find the best solution for this puzzle for decades now. One disadvantage which is often mentioned in this context is the fact that many languages have died because of the spread of English. Many still have lost a large number of speakers and are bound to be doomed in the near future. These are the disadvantages, and while they certainly seem gloomy, there are many advantages of having a global language.', sysdate, 4);
insert  into article (id, active, picture, slug, teaser, title, private_article) values (9, true, null, 'english-global-language', 'A discussion about English language', 'English as a global language, a good or bad thing?', false) ;
insert into article_tags (article_id, tags) values (9, 'Artigo, English');

insert into document(id, body, posted_on, user_id) values (10, 'Heroic investigations of life and disease have put us on the verge of a health-care revolution. Meanwhile, the software industry is booming; tech startups appear faster than you can say “medical informatics.” But at the intersection of these two complex fields lies dysfunction. Researchers and clinicians, shackled to software that no one in their right mind would use voluntarily, spend countless hours manually copying data from one system to another. And this separation of software development from clinical research is costing lives', sysdate, 1);
insert into article (id, active, picture, slug , teaser, title, private_article) values (10, true, null, 'researchers-hackers','Clinical researchers need programming support to streamline their work, minimize error in the data, and find new trends that can point to better treatments', 'Researchers, Hire Hackers', false);
insert into article_tags (article_id, tags) values (10, 'Echo, Foxtrot');

-- COMMENTS
insert into comment (id, document_id) values (1, 2);
insert into comment (id, document_id) values (2, 7);
insert into comment (id, document_id) values (3, 8);
insert into comment (id, document_id) values (4, 9);
insert into comment (id, document_id) values (5, 10);
insert into comment (id, document_id) values (6, 1);
insert into comment (id, document_id) values (7, 3);
insert into comment (id, document_id) values (8, 4);
insert into comment (id, document_id) values (9, 5);
insert into comment (id, document_id) values (10, 6);

-- ARTICLE RANK
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 1, 2, 1);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 2, 7, 2);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 3, 8, 3);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 4, 9, 4);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 5, 10, 5);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 2, 2, 6);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 3, 7, 7);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 2, 8, 8);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 3, 9, 9);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 4, 10, 10);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 4, 2, 1);
insert into article_rank (created_on, rank, article_id, author_user_id) values (sysdate, 5, 2, 8);

-- POST AND COMMENTS

-- POST
insert into document(id, body, posted_on, user_id) values (11, 'Body 11', sysdate, 1);
insert into post (id, title, subject, is_public) values (11, 'Title11', 'Subject11', false);
insert into post_tags (post_id, tags) values (11, 'PostTag11-1, PostTag11-2, PostTag11-3, PostTag11-4, PostTag11-5');
-- COMMENTS
insert into document(id, body, posted_on, user_id) values (12, 'Body 12 - Aponta body 11', sysdate, 2);
insert into comment (id, document_id) values (12, 11);

insert into document(id, body, posted_on, user_id) values (13, 'Body 13 - Aponta body 11', sysdate, 3);
insert into comment (id, document_id) values (13, 11);

insert into document(id, body, posted_on, user_id) values (14, 'Body 14 - Aponta body 11', sysdate, 4);
insert into comment (id, document_id) values (14, 11);

insert into document(id, body, posted_on, user_id) values (15, 'Body 15 - Aponta body 13', sysdate, 2);
insert into comment (id, document_id) values (15, 13);

insert into document(id, body, posted_on, user_id) values (16, 'Body 16 - Aponta body 13', sysdate, 2);
insert into comment (id, document_id) values (16, 13);

insert into document(id, body, posted_on, user_id) values (17, 'Body 17 - Aponta body 14', sysdate, 2);
insert into comment (id, document_id) values (17, 14);

insert into document(id, body, posted_on, user_id) values (18, 'Body 18', sysdate, 2);
insert into comment (id, document_id) values (18, 14);

insert into document(id, body, posted_on, user_id) values (19, 'Body 19', sysdate, 2);
insert into comment (id, document_id) values (19, 18);


--INSERT POST 23
insert into document(ID , BODY , POSTED_ON , USER_ID ) values (23, 'Sou corpo do Post  23', sysdate, 1);

insert into post (ID , TITLE, SUBJECT , IS_PUBLIC, RANK_ID ,  ) values (23, 'Sou o post  23', 'Assunto qualquer', true, null);

insert into post_tags (POST_ID , TAGS ) values (23, 'PostTag1, PostTag2');

--primeiro comentário do Post 23 com id=24
insert into document(ID , BODY , POSTED_ON , USER_ID ) values (24, 'Sou o comentário do post 13', sysdate, 2);

insert into comment (ID ,DOCUMENT_ID ) values (24, 23);

insert into DOCUMENT_COMMENTS(document_id, comments_id) values(23, 24);


--segundo comentário do Post 23 com id= 25
insert into document(ID , BODY , POSTED_ON , USER_ID ) values (25, 'Sou o segundo comentário do post 13', sysdate, 3);

insert into comment (ID ,DOCUMENT_ID ) values (25, 23);

insert into DOCUMENT_COMMENTS(document_id, comments_id) values(23, 25);
