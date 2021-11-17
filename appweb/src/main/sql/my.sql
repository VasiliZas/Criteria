CREATE SCHEMA au AUTHORIZATION vasili;

CREATE TABLE au.car (
                        modeltype varchar NULL,
                        fuel varchar NULL,
                        "type" varchar NULL,
                        id int4 NOT NULL
);


CREATE TABLE au.fuel (
                         fuel int4 NOT NULL DEFAULT nextval('au.fuel_id_seq'::regclass),
                         typefuel varchar NULL,
                         CONSTRAINT fuel_pk PRIMARY KEY (fuel)
);
CREATE UNIQUE INDEX fuel_id_uindex ON au.fuel USING btree (fuel);

CREATE TABLE au.moto (
                         id serial4 NOT NULL,
                         modeltype varchar NULL,
                         fuel int4 NULL,
                         sport varchar NULL,
                         CONSTRAINT moto_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX moto_id_uindex ON au.moto USING btree (id);


-- au.moto foreign keys

ALTER TABLE au.moto ADD CONSTRAINT moto_fuel_id_fk FOREIGN KEY (fuel) REFERENCES au.fuel(fuel);

INSERT INTO au.car (modeltype, fuel, "type", id) VALUES('BMW', 'DIESEL', 'SEDAN', 1);
INSERT INTO au.car (modeltype, fuel, "type", id) VALUES('OPEL', 'PETROL', 'SUV', 2);
INSERT INTO au.car (modeltype, fuel, "type", id) VALUES('FIAT', 'ELECTRO', 'CUPE', 3);

INSERT INTO au.fuel (fuel, typefuel) VALUES(1, 'DIESEL');
INSERT INTO au.fuel (fuel, typefuel) VALUES(2, 'PETROL');
INSERT INTO au.fuel (fuel, typefuel) VALUES(3, 'ELECTRO');

INSERT INTO au.moto (id, modeltype, fuel, sport) VALUES(1, 'Yamaha', 2, 'cross');
INSERT INTO au.moto (id, modeltype, fuel, sport) VALUES(3, 'Minsk', 2, 'no');
INSERT INTO au.moto (id, modeltype, fuel, sport) VALUES(2, 'KTM', 3, 'cross');
