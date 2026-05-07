CREATE TABLE IF NOT EXISTS job (
    key SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_last TIMESTAMP,
    fl_work INTEGER DEFAULT 0,
    date_update TIMESTAMP
);