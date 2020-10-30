create table if not exists users(
    id int primary key not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    cell_num int not null,
    date_created date not null
);
