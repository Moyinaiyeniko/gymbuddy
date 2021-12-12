---- Database: news
--
---- DROP DATABASE news;
--
--CREATE DATABASE news
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'English_United States.1252'
--    LC_CTYPE = 'English_United States.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;
--
---- User: postgres
---- DROP USER postgres;
--
--CREATE USER postgres WITH
--  LOGIN
--  SUPERUSER
--  INHERIT
--  CREATEDB
--  CREATEROLE
--  REPLICATION;
--
---- SCHEMA: schema_news
--
---- DROP SCHEMA schema_news ;
--
--CREATE SCHEMA schema_news
--    AUTHORIZATION postgres;
--
---- Table: schema_news.article
--
---- DROP TABLE schema_news.article;

C-- Table: gymbuddy.executive

 -- DROP TABLE gymbuddy.executive;

 CREATE TABLE gymbuddy.executive
 (
     id character varying COLLATE pg_catalog."default" NOT NULL,
     firstname character varying(50) COLLATE pg_catalog."default" NOT NULL,
     lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
     CONSTRAINT executive_pkey PRIMARY KEY (id)
 )
 WITH (
     OIDS = FALSE
 )
 TABLESPACE pg_default;

 ALTER TABLE gymbuddy.executive
     OWNER to postgres;


-- Table: gymbuddy.users

-- DROP TABLE gymbuddy.users;

CREATE TABLE gymbuddy.users
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying(250) COLLATE pg_catalog."default" NOT NULL,
    usertype character varying(250) COLLATE pg_catalog."default",
    password character varying(250) COLLATE pg_catalog."default",
    executive_id character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk_executive FOREIGN KEY (executive_id)
        REFERENCES gymbuddy.executive (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE gymbuddy.users
    OWNER to postgres;



-- Table: gymbuddy.role

-- DROP TABLE gymbuddy.role;

CREATE TABLE gymbuddy.role
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    rolename character varying(250) COLLATE pg_catalog."default" NOT NULL,
    description character varying(250) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE gymbuddy.role
    OWNER to postgres;



-- Table: gymbuddy.users_role

-- DROP TABLE gymbuddy.users_role;

CREATE TABLE gymbuddy.users_role
(
    role_id character varying COLLATE pg_catalog."default",
    users_id character varying COLLATE pg_catalog."default",
    CONSTRAINT fk_role FOREIGN KEY (role_id)
        REFERENCES gymbuddy.role (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_users FOREIGN KEY (users_id)
        REFERENCES gymbuddy.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE gymbuddy.users_role
    OWNER to postgres;


