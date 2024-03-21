CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50)
);

CREATE TABLE cars (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      model VARCHAR(50),
                      ownerId INT,
                      FOREIGN KEY (ownerId) REFERENCES users(id)
);