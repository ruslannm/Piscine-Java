INSERT INTO chat.user (login, password) VALUES
('Henry', '123456'),
('Oliver', '123456'),
('John', '123456'),
('Thomas', '123456'),
('Jacob', '123456');

INSERT INTO chat.room (name, createdBy) VALUES
('Chat1', (SELECT id FROM chat.user WHERE login = 'Henry')),
('Chat2', (SELECT id FROM chat.user WHERE login = 'Oliver')),
('Chat3', (SELECT id FROM chat.user WHERE login = 'John')),
('Chat4', (SELECT id FROM chat.user WHERE login = 'Thomas')),
('Chat5', (SELECT id FROM chat.user WHERE login = 'Jacob'));

INSERT INTO chat.message (author, room, text, date) VALUES
((SELECT id FROM chat.user WHERE login = 'Henry'),
 (SELECT id FROM chat.room WHERE name = 'Chat1'),
 'Message1','2021-08-30 20:57:04'),
((SELECT id FROM chat.user WHERE login = 'Oliver'),
 (SELECT id FROM chat.room WHERE name = 'Chat2'),
 'Message1','2021-08-30 21:07:04'),
((SELECT id FROM chat.user WHERE login = 'John'),
 (SELECT id FROM chat.room WHERE name = 'Chat3'),
 'Message1','2021-08-30 21:17:04'),
((SELECT id FROM chat.user WHERE login = 'Thomas'),
 (SELECT id FROM chat.room WHERE name = 'Chat4'),
 'Message1','2021-08-30 21:27:04'),
((SELECT id FROM chat.user WHERE login = 'Jacob'),
 (SELECT id FROM chat.room WHERE name = 'Chat5'),
 'Message1','2021-08-30 21:37:04');

INSERT INTO chat.chat (userId, roomId) VALUES
((SELECT id FROM chat.user WHERE login = 'Henry'),
 (SELECT id FROM chat.room WHERE name = 'Chat1'))
((SELECT id FROM chat.user WHERE login = 'Oliver'),
 (SELECT id FROM chat.room WHERE name = 'Chat2')),
((SELECT id FROM chat.user WHERE login = 'John'),
 (SELECT id FROM chat.room WHERE name = 'Chat3')),
((SELECT id FROM chat.user WHERE login = 'Thomas'),
 (SELECT id FROM chat.room WHERE name = 'Chat4')),
((SELECT id FROM chat.user WHERE login = 'Jacob'),
 (SELECT id FROM chat.room WHERE name = 'Chat5'));
