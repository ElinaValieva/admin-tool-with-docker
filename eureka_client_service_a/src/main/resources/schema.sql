create table if not exists tservice
(
	id serial not null
		constraint service_pkey
			primary key,
	service varchar(100)
)
;

alter table tservice owner to admindb;
;

create unique index if not exists service_id_uindex
	on tservice (id)
;

create table if not exists type_access
(
	id serial not null
		constraint type_access_pkey
			primary key,
	access varchar(100)
)
;

alter table type_access owner to admindb;
;

create unique index if not exists type_access_id_uindex
	on type_access (id)
;

create table if not exists access
(
	id serial not null
		constraint opportunities_pkey
			primary key,
	access_name varchar(100),
	t_service_id integer
		constraint opportunities_service_id_fk
			references tservice,
	type_access_id integer
		constraint access_type_access_id_fk
			references type_access
)
;

alter table access owner to admindb;
;

create unique index if not exists opportunities_id_uindex
	on access (id)
;

create table if not exists credentials
(
	id serial not null
		constraint credentials_pkey
			primary key,
	user_login varchar(100),
	user_password varchar(100)
)
;

alter table credentials owner to admindb;
;

create unique index if not exists credentials_id_uindex
	on credentials (id)
;

create table if not exists roles
(
	id serial not null
		constraint roles_pkey
			primary key,
	role varchar(100)
)
;

alter table roles owner to admindb;
;

create unique index if not exists roles_id_uindex
	on roles (id)
;

create table if not exists user_auth
(
	id serial not null
		constraint user_roles_pk
			primary key,
	user_number integer,
	user_name varchar(100),
	credentials_id integer
		constraint user_credentials_id_fk
			references credentials
				on delete cascade
)
;

alter table user_auth owner to admindb;
;

create unique index if not exists user_id_uindex
	on user_auth (id)
;

-- auto-generated definition
create table user_roles
(
  user_auth_id integer
    constraint user_roles_user_id_fk
    references user_auth
    on delete cascade,
  role_id integer
    constraint user_roles_roles_id_fk
    references roles
    on update cascade
);

alter table user_roles
  owner to admindb;

 -- auto-generated definition
create table role_access
(
  role_id   integer
    constraint role_opportunities_roles_id_fk
    references roles,
  access_id integer
    constraint role_opportunities_opportunities_id_fk
    references access
);

alter table role_access
  owner to admindb;
