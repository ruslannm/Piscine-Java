CREATE SCHEMA IF NOT EXISTS chat;
CREATE TABLE IF NOT EXISTS chat.user (
    id BIGSERIAL PRIMARY KEY,
	login VARCHAR (50) UNIQUE NOT NULL,
	password VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.room (
    id BIGSERIAL PRIMARY KEY,
	name VARCHAR (50) UNIQUE NOT NULL,
	createdBy BIGINT NOT NULL,
	FOREIGN KEY (createdBy) REFERENCES chat.user (Id)
);

CREATE TABLE IF NOT EXISTS chat.message (
    id BIGSERIAL PRIMARY KEY,
	author BIGINT,
	FOREIGN KEY (author) REFERENCES chat.user (id),
	room BIGINT,
	FOREIGN KEY (room) REFERENCES chat.room (id),
	text TEXT,
	date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chat.chat(
    userId BIGINT NOT NULL,
    roomId BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES chat.user(id),
    FOREIGN KEY (roomId) REFERENCES chat.room(id),
    UNIQUE (userId, roomId)
);