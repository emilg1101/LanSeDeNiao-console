CREATE TABLE new_schema."like"
(
    id integer DEFAULT nextval('new_schema.like_id_seq'::regclass) PRIMARY KEY NOT NULL,
    post_id integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT like_post_id_fk FOREIGN KEY (post_id) REFERENCES new_schema.post (id),
    CONSTRAINT like_user_id_fk FOREIGN KEY (user_id) REFERENCES new_schema."user" (id)
);
CREATE UNIQUE INDEX like_id_uindex ON new_schema."like" (id);
INSERT INTO new_schema."like" (id, post_id, user_id) VALUES (2, 1, 3);
INSERT INTO new_schema."like" (id, post_id, user_id) VALUES (3, 2, 3);
INSERT INTO new_schema."like" (id, post_id, user_id) VALUES (4, 1, 1);
INSERT INTO new_schema."like" (id, post_id, user_id) VALUES (5, 2, 1);
CREATE TABLE new_schema.post
(
    id integer DEFAULT nextval('new_schema.post_id_seq'::regclass) PRIMARY KEY NOT NULL,
    user_id integer NOT NULL,
    text varchar(1024) NOT NULL,
    cdate timestamp DEFAULT now(),
    CONSTRAINT post_user_id_fk FOREIGN KEY (user_id) REFERENCES new_schema."user" (id)
);
CREATE UNIQUE INDEX post_id_uindex ON new_schema.post (id);
INSERT INTO new_schema.post (id, user_id, text, cdate) VALUES (1, 1, 'My first post!!!', '2019-03-21 13:10:49.636925');
INSERT INTO new_schema.post (id, user_id, text, cdate) VALUES (2, 1, 'My 2nd post.', '2019-03-21 15:49:17.680557');
INSERT INTO new_schema.post (id, user_id, text, cdate) VALUES (4, 3, 'test', '2019-03-22 00:08:35.490726');
CREATE TABLE new_schema."user"
(
    id integer DEFAULT nextval('new_schema.user_id_seq'::regclass) PRIMARY KEY NOT NULL,
    username varchar(20) NOT NULL,
    password varchar(255) NOT NULL,
    email varchar(100) NOT NULL,
    bdate timestamp,
    country varchar(20) DEFAULT NULL::character varying,
    gender integer DEFAULT 2 NOT NULL,
    rdate timestamp DEFAULT now() NOT NULL,
    name varchar(30) DEFAULT NULL::character varying
);
CREATE UNIQUE INDEX user_id_uindex ON new_schema."user" (id);
CREATE UNIQUE INDEX user_username_uindex ON new_schema."user" (username);
CREATE UNIQUE INDEX user_email_uindex ON new_schema."user" (email);
INSERT INTO new_schema."user" (id, username, password, email, bdate, country, gender, rdate, name) VALUES (1, 'emilg1101', '123', 'emilyandro99@gmail.com', null, null, 2, '2019-03-20 05:26:58.123423', null);
INSERT INTO new_schema."user" (id, username, password, email, bdate, country, gender, rdate, name) VALUES (3, 'admin', 'admin', 'admin@admin', null, null, 2, '2019-03-21 15:53:05.725781', null);