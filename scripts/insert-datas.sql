use crud;

INSERT INTO users (id, name, surname, email, birthdate) VALUES
                                                            (UUID(), 'Jones', 'Johnson', 'johnson@example.com', '1990-05-15'),
                                                            (UUID(), 'Maria', 'Smith', 'maria@example.com', '1985-08-20'),
                                                            (UUID(), 'Pedro', 'Brown', 'pedro@example.com', '1978-03-10');