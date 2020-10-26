create table accounts(
    id serial not null primary key,
    account_name text not null,
    account_type text not null, 
    account_num int not null,
    balance decimal(10, 2) not null,
    date_created date not null

);