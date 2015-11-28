
 CREATE ROLE priyahomes WITH LOGIN PASSWORD 'admin' SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

 CREATE DATABASE priyahomes
  WITH OWNER = priyahomes
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_IN'
       LC_CTYPE = 'en_IN'
       CONNECTION LIMIT = -1;

CREATE TABLE ph_internal_users (
	username varchar(50) NOT NULL,
	password varchar(100) NOT NULL,
	enable bool,
	CONSTRAINT ph_internal_user_pk PRIMARY KEY (username)
);

INSERT INTO ph_internal_user(username,password,enable) VALUES('admin','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y',true);
COMMIT;
