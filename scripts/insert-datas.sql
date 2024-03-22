use crud;

INSERT INTO crud.users (id, name) VALUES
                             (UUID_TO_BIN(UUID()), 'Jones'),
                             (UUID_TO_BIN(UUID()), 'Maria'),
                             (UUID_TO_BIN(UUID()), 'Pedro');

INSERT INTO crud.cars (id, model, owner_id) VALUES
                                           (UUID_TO_BIN(UUID()), 'Toyota Corolla', (SELECT id FROM crud.users WHERE name = 'Jones')),
                                           (UUID_TO_BIN(UUID()), 'Honda Civic', (SELECT id FROM crud.users WHERE name = 'Maria')),
                                           (UUID_TO_BIN(UUID()), 'Ford Focus', (SELECT id FROM crud.users WHERE name = 'Pedro')),
                                           (UUID_TO_BIN(UUID()), 'Volkswagen Golf', (SELECT id FROM crud.users WHERE name = 'Jones'));