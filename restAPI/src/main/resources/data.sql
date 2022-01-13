INSERT INTO roles(id, name)
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN'),
       (3, 'ROLE_MODERATOR');

INSERT INTO user(id, password, username, email)
VALUES (1, 'admin', 'admin', 'admin@admin.com');

insert into user_roles(user_id, role_id)
VALUES (1, 2)



