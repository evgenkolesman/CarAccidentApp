--
-- DROP TABLE rule;
-- DROP TABLE type;
-- DROP  TABLE  accident;
-- CREATE TABLE rule(
--                      id SERIAL PRIMARY KEY,
--                      name TEXT
-- --                      accident_id int references accident(id)
-- );
--
-- CREATE TABLE atype(
--                      id SERIAL PRIMARY KEY,
--                      name TEXT
-- --                      accident_id int references accident(id)
-- );
CREATE TABLE accident (
                          id serial primary key,
                          name varchar(2000),
                          text TEXT,
                          adress TEXT,
                          atype_id int references atype(id),
                          rule_id int references rule(id)
);





CREATE TABLE accident_type (
    id SERIAL PRIMARY KEY,
    atype_id int references atype(id),
    accident_id int references accident(id)
);
CREATE TABLE accident_rule (
                               id SERIAL PRIMARY KEY,
                               rule_id int references rule(id),
                               accident_id int references accident(id)
);
