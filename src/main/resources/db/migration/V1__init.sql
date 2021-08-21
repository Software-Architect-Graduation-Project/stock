CREATE TABLE public."stock_record" (
    id serial NOT NULL,
    order_id varchar NOT NULL,
    products varchar NOT NULL,
    created_on timestamp(0) NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
);