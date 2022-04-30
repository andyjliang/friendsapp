CREATE SCHEMA friendsapp;

CREATE TABLE friendsapp.user (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100)
 );

CREATE TABLE friendsapp.group (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100),
	active               bit
 );

CREATE TABLE friendsapp.friend (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	name                 varchar(100)
 );

CREATE TABLE friendsapp.activity (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	title                varchar(100),
	description          varchar(300),
 );

CREATE TABLE friendsapp.user_group (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	user_id              FOREIGN KEY REFERENCES friendsapp.user(id),
	group_id             FOREIGN KEY REFERENCES friendsapp.group(id)
 );

CREATE TABLE friendsapp.friend_group (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	friend_id            FOREIGN KEY REFERENCES friendsapp.friend(id),
	group_id             FOREIGN KEY REFERENCES friendsapp.group(id)
 );

CREATE TABLE friendsapp.group_activity (
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	activity_id          FOREIGN KEY REFERENCES friendsapp.activity(id),
	group_id             FOREIGN KEY REFERENCES friendsapp.group(id)
 );