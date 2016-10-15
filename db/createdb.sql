\connect proj2web

CREATE TABLE usuario
(
	nome	VARCHAR(100),
	email	VARCHAR(100),
	login	VARCHAR(15),
	senha	VARCHAR(100),
	estado	VARCHAR(2),
	cidade 	VARCHAR(100),
	bairro	VARCHAR(50),
	rua 	VARCHAR(100),
	numero	VARCHAR(5),
	CONSTRAINT user_pk PRIMARY KEY(login),
	CONSTRAINT email_c UNIQUE(email),
	CONSTRAINT nome_c CHECK (nome <> ''),
	CONSTRAINT senha_c CHECK (char_length(senha) >= 8)
);

CREATE TABLE data
(
	login	VARCHAR(15) REFERENCES usuario (login),
	tipo	INTEGER,
	caminho	VARCHAR(200),
	CONSTRAINT data_pk PRIMARY KEY(caminho),
	CONSTRAINT tipo_c CHECK (tipo >= 0)
); 

