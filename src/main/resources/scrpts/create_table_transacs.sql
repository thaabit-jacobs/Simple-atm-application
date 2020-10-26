create table transactions(
    id serial not null primary key,
    transaction_type text not null,
    transactions_date date not null,
    success boolean null,
    transactions_amount decimal(10, 2) not null
);