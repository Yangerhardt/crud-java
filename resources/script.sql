CREATE DATABASE agenda;

CREATE TABLE contatos(
    id INT NOT NULL auto_increment PRIMARY KEY,
    nome VARCHAR(40),
    idade INT,
    dataCadastro DATE
)