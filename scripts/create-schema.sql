use crud;

CREATE TABLE users (
                       id BINARY(16) PRIMARY KEY,
                       name VARCHAR(50),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE cars (
                      id BINARY(16) PRIMARY KEY,
                      model VARCHAR(50),
                      owner_id BINARY(16),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      FOREIGN KEY (owner_id) REFERENCES users(id)
);