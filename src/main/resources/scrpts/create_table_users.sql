create table users(
    id serial not null primary key,
    first_name text not null,
    last_name text not null, 
    user_name text not null,
    password text not null,
    cell_no int not null,
    date_created date not null
);