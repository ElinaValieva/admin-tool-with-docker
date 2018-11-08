INSERT INTO type_access (id, access) VALUES (1, 'READONLY');
INSERT INTO type_access (id, access) VALUES (2, 'READWRITE');
INSERT INTO type_access (id, access) VALUES (3, 'ACCESSABLE');

INSERT INTO tservice (id, service) VALUES (1, 'Service A');
INSERT INTO tservice (id, service) VALUES (2, 'Service B');

INSERT INTO access (id, access_name, t_service_id, type_access_id) VALUES (1, 'READONLY_SERVICE_A', 1, 1);
INSERT INTO access (id, access_name, t_service_id, type_access_id) VALUES (2, 'READONLY_SERVICE_B', 2, 1);
INSERT INTO access (id, access_name, t_service_id, type_access_id) VALUES (3, 'ACCESSABLE_SERVICE_A', 1, 3);
INSERT INTO access (id, access_name, t_service_id, type_access_id) VALUES (4, 'ACCESSABLE_SERVICE_B', 2, 3);
INSERT INTO access (id, access_name, t_service_id, type_access_id) VALUES (5, 'READWRITE_SERVICE_A', 1, 2);

INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, role) VALUES (2, 'ROLE_USER');

INSERT INTO role_access (role_id, access_id) VALUES (2, 1);
INSERT INTO role_access (role_id, access_id) VALUES (1, 1);
INSERT INTO role_access (role_id, access_id) VALUES (1, 2);
INSERT INTO role_access (role_id, access_id) VALUES (1, 3);
INSERT INTO role_access (role_id, access_id) VALUES (1, 4);
INSERT INTO role_access (role_id, access_id) VALUES (1, 5);

INSERT INTO credentials (id, user_login, user_password) VALUES (1, 'admin', '$2a$10$4Q/44srZA2cyViV64fJauuSdNdQY69ZZBzHrVie2mCWPfbsoyl3Dy');
INSERT INTO credentials (id, user_login, user_password) VALUES (2, 'user', '$2a$10$C7TOLL5JG0bCJfFvye5eO.cYgRW0fOqn75aqQBCHd9ZbDRCtC4Z6y');

INSERT INTO user_auth (id, user_number, user_name, credentials_id) VALUES (1, 1000, 'admin', 1);
INSERT INTO user_auth (id, user_number, user_name, credentials_id) VALUES (2, 765733, 'user', 2);

INSERT INTO user_roles (user_auth_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_auth_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_auth_id, role_id) VALUES (1, 2);