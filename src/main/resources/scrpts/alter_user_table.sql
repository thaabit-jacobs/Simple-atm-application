alter table users add account_id int;

alter table users add foreign key (account_id) references accounts(id); 