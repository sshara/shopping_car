
CREATE TABLE IF NOT EXISTS shopping_cars
(
    id integer PRIMARY KEY
);


CREATE TABLE IF NOT EXISTS items
(
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    price double precision NOT NULL,
	amount integer NOT NULL,
    description character varying(50),
    id_shopping_car integer,
    PRIMARY KEY (id),
    CONSTRAINT fk_shopping_car FOREIGN KEY (id_shopping_car)
        REFERENCES shopping_cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);



CREATE SEQUENCE IF NOT EXISTS sequence_item
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
	ALTER SEQUENCE sequence_item
    OWNER TO postgres;