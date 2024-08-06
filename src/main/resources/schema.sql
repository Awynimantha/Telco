CREATE TABLE IF NOT EXISTS "Userdfd" (
    id identity PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phonenumber VARCHAR(15) NOT NULL,
    age INT NOT NULL CHECK (age >= 0)
);
