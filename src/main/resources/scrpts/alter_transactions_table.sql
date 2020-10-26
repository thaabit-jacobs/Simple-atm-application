alter table transactions add account_id int;

alter table transactions add foreign key (account_id) references accounts(id); 