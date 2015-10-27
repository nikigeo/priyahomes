CREATE  TABLE ph_users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled BOOLEAN NOT NULL DEFAULT '1' ,
  PRIMARY KEY (username));

INSERT INTO ph_users(username,password,enabled)
VALUES ('admin','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);