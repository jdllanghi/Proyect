CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_type VARCHAR(20) CHECK (user_type IN ('free', 'premium')) NOT NULL,
    PRIMARY KEY(id)
    );


CREATE TABLE IF NOT EXISTS "progress" (
    id SERIAL,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    start_date DATE,
    last_read DATE,
    pages_read INT DEFAULT 0,
    status VARCHAR(20) CHECK (status IN ('in_progress', 'completed')) DEFAULT 'in_progress',
    PRIMARY KEY(id)
    );
