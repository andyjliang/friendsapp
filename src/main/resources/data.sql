CREATE SCHEMA friendsapp;

CREATE TABLE friendsapp.users (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100)
 );

CREATE TABLE friendsapp.groups (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100),
	active               bit
 );

CREATE TABLE friendsapp.friends (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100)
 );

CREATE TABLE friendsapp.activities (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	title                varchar(100),
	description          varchar(300)
 );

CREATE TABLE friendsapp.user_group (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	user_id              int  NOT NULL,
	group_id             int  NOT NULL,
	FOREIGN KEY (user_id) REFERENCES friendsapp.users(id),
	FOREIGN KEY (group_id) REFERENCES friendsapp.groups(id)
 );

CREATE TABLE friendsapp.friend_group (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	friend_id            int  NOT NULL,
	group_id             int  NOT NULL,
	FOREIGN KEY (friend_id) REFERENCES friendsapp.friends(id),
	FOREIGN KEY (group_id) REFERENCES friendsapp.groups(id)
 );

CREATE TABLE friendsapp.group_activity (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	activity_id          int  NOT NULL,
	group_id             int  NOT NULL,
	FOREIGN KEY (activity_id) REFERENCES friendsapp.activities(id),
	FOREIGN KEY (group_id) REFERENCES friendsapp.groups(id)
 );