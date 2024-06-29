-- dog.sql

-- Drop the table if it exists (to avoid errors during re-creation)
DROP TABLE IF EXISTS dog;

-- Create a table to store dog information
CREATE TABLE dog (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    breed VARCHAR(255),
    age INT
);

-- Insert 10 dogs with different breeds
INSERT INTO dog (name, breed, age) VALUES
    ('Buddy', 'Golden Retriever', 3),
    ('Max', 'German Shepherd', 2),
    ('Bailey', 'Labrador Retriever', 4),
    ('Charlie', 'Poodle', 1),
    ('Lucy', 'Beagle', 5),
    ('Daisy', 'Boxer', 2),
    ('Rocky', 'Siberian Husky', 3),
    ('Luna', 'Dalmatian', 2),
    ('Cooper', 'Bulldog', 4),
    ('Sadie', 'Australian Shepherd', 3);