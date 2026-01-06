
CREATE DATABASE mini_dish_db;


CREATE USER mini_dish_db_manager WITH PASSWORD '123456';  -- Change si tu veux un autre mot de passe


GRANT ALL PRIVILEGES ON DATABASE mini_dish_db TO mini_dish_db_manager;


\c mini_dish_db


GRANT CREATE ON SCHEMA public TO mini_dish_db_manager;


GRANT ALL ON SCHEMA public TO mini_dish_db_manager;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO mini_dish_db_manager;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO mini_dish_db_manager;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TYPES TO mini_dish_db_manager;