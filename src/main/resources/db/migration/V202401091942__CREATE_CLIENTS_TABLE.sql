create schema if not exists ecomm_clients;

create table ecomm_clients.tb_client(
    client_id serial primary key,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    document varchar(20) not null,
    date_of_birth varchar(20),
    email varchar(100) not null,
    phone_number varchar(20) not null,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null
);

alter table ecomm_clients.tb_client owner to admin;
grant all on table ecomm_clients.tb_client to admin;
grant select,insert,update,delete on table ecomm_clients.tb_client to admin;