

CREATE TYPE category_enum AS ENUM ('VEGETABLE', 'ANIMAL', 'MARINE', 'DAIRY', 'OTHER');
CREATE TYPE dish_type_enum AS ENUM ('START', 'MAIN', 'DESSERT');


CREATE TABLE Dish (
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    dish_type dish_type_enum NOT NULL
);


CREATE TABLE Ingredient (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(100) NOT NULL UNIQUE,
    price    NUMERIC(10,2) NOT NULL,
    category category_enum NOT NULL,
    id_dish  INT,
    CONSTRAINT fk_dish FOREIGN KEY (id_dish) references Dish(id) on delete  set null
);

drop table Dish