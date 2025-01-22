-- Criar tabela de viagens
CREATE TABLE viagens ( 
    id SERIAL PRIMARY KEY,
    id_navio INT NOT NULL,
    status_viagem VARCHAR(255) NOT NULL,
    id_berco INT NOT NULL,
    tipo_carga VARCHAR(255) NOT NULL
);

-- Criar tabela de navios
CREATE TABLE navios (
    id SERIAL PRIMARY KEY,
    nome_navio_classe VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL
);

-- Criar tabela de tipos de carga
CREATE TABLE tipos_carga (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Criar tabela de usuários
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome_usuario VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
