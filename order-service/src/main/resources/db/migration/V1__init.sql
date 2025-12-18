create table order_details (
        price float(53),
        quantity integer not null,
        id bigint not null auto_increment,
        order_number varchar(255),
        sku_code varchar(255),
        primary key (id)
);

