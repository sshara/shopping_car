
CREATE TABLE IF NOT EXISTS public.shopping_cars
(
    id integer NOT NULL
    CONSTRAINT pk_recibo PRIMARY KEY (id)
)

TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.items
(
    id integer NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    price double precision NOT NULL,
	amount integer NOT NULL,
    description character varying(50) COLLATE pg_catalog."default",
    id_shopping_car integer,
    CONSTRAINT item_pkey PRIMARY KEY (id),
    CONSTRAINT fk_shopping_car FOREIGN KEY (id_shopping_car)
        REFERENCES public.shopping_cars (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;


CREATE SEQUENCE IF NOT EXISTS public.sequence_item
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
	ALTER SEQUENCE public.sequence_item
    OWNER TO postgres;
	
CREATE SEQUENCE IF NOT EXISTS public.sequence_shopping_car
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

	ALTER SEQUENCE public.sequence_shopping_car
    OWNER TO postgres;