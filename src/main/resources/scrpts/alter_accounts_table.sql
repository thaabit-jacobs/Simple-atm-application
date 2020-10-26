alter table accounts add transaction_id int;

alter table accounts add foreign key (transaction_id) references transactions(id); 