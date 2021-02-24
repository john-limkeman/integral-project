BEGIN TRANSACTION;

DROP TABLE IF EXISTS Posts;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users(

id serial,
username varchar(64) not null UNIQUE,
password varchar(64) not null,

constraint pk_Users primary key (id)
);

CREATE TABLE Posts(
id serial not null,
user_id int not null,
content varchar not null,
postingTime timestamp not null,

constraint pk_Posts primary key (id),
constraint fk_Posts_userId foreign key (user_id) REFERENCES Users (id)

);

CREATE TABLE Followings(
follower_id int not null,
following_id int not null,

constraint pk_followings primary key (follower_id, following_id),
constraint fk_followings_follower foreign key (follower_id) references Users (id),
constraint fk_followings_following foreign key (following_id) references Users (id)
);


INSERT INTO Users (username, password) VALUES ('john', 'password'); 
INSERT INTO Users (username, password) VALUES ('alice', 'password'); 
INSERT INTO Users (username, password) VALUES ('andy', 'password'); 
INSERT INTO Users (username, password) VALUES ('katie', 'password');

INSERT INTO Posts (user_id, content, postingTime) VALUES (1, 'hello world', '2021-01-19 10:23:54');
INSERT INTO Posts (user_id, content, postingTime) VALUES (1, 'my name is john', '2021-01-19 11:23:54');
INSERT INTO Posts (user_id, content, postingTime) VALUES (2, 'my name is alice', '2021-01-19 10:24:56');
INSERT INTO Posts (user_id, content, postingTime) VALUES (3, 'my name is andy', '2021-02-19 10:23:54');
INSERT INTO Posts (user_id, content, postingTime) VALUES (4, 'my name is katie', '2021-02-20 12:23:54');

INSERT INTO Followings (follower_id, following_id) VALUES (1, 2);
INSERT INTO Followings (follower_id, following_id) VALUES (1, 3);
INSERT INTO Followings (follower_id, following_id) VALUES (1, 4);
INSERT INTO Followings (follower_id, following_id) VALUES (2, 1);
INSERT INTO Followings (follower_id, following_id) VALUES (2, 3);
