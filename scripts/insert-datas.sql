INSERT INTO users (id, name) VALUES
                                 ('4a6101b4-6a89-11ec-8c9c-0242ac130003', 'Jones'),
                                 ('5517d518-6a89-11ec-8c9c-0242ac130003', 'Maria'),
                                 ('6ab05d08-6a89-11ec-8c9c-0242ac130003', 'Pedro');

INSERT INTO cars (id, model, owner_id) VALUES
                                           ('79354e4e-6a89-11ec-8c9c-0242ac130003', 'Toyota Corolla', (SELECT id FROM users WHERE name = 'Jones')),
                                           ('5517d518-6a89-11ec-8c9c-0242ac130003', 'Honda Civic', (SELECT id FROM users WHERE name = 'Maria')),
                                           ('6ab05d08-6a89-11ec-8c9c-0242ac130003', 'Ford Focus', (SELECT id FROM users WHERE name = 'Pedro')),
                                           ('79354e4e-6a89-11ec-8c9c-0242ac130003', 'Volkswagen Golf', (SELECT id FROM users WHERE name = 'Jones'));