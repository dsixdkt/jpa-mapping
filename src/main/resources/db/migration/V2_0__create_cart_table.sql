CREATE TABLE if not exists cart_entity (
    id bigint NOT NULL PRIMARY KEY,
 --   id bigint NOT NULL DEFAULT nextval('cart_entity_id_seq') PRIMARY KEY,
    name varchar(50)
);
