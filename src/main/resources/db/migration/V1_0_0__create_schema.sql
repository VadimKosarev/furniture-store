CREATE TABLE furniture
(
    id           bigserial PRIMARY KEY,
    article      varchar(25),
    name         varchar(50),
    category     varchar(50),
    model        varchar(25),
    description  varchar,
    amount       bigint,
    manufacturer varchar(25)
);

CREATE TABLE orders
(
    id               bigserial PRIMARY KEY,
    tracking_number  varchar(50),
    date_of_creation varchar(50),
    name_client      varchar(22),
    email_client     varchar(23),
    total_amount     bigint
);

CREATE TABLE furniture_orders
(
    furniture_id bigint REFERENCES furniture (id),
    orders_id    bigint REFERENCES orders (id),
    PRIMARY KEY (furniture_id, orders_id)
);
