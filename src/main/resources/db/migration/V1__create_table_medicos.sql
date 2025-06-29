CREATE TABLE medicos (
                         id BIGSERIAL PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         telefono VARCHAR(100) NOT NULL UNIQUE,
                         documento VARCHAR(12) NOT NULL UNIQUE,
                         especialidad VARCHAR(100) NOT NULL,
                         calle VARCHAR(100) NOT NULL,
                         numero VARCHAR(100),
                         complemento VARCHAR(100),
                         barrio VARCHAR(100) NOT NULL,
                         ciudad VARCHAR(100) NOT NULL,
                         estado VARCHAR(100) NOT NULL,
                         codigo_postal VARCHAR(100) NOT NULL
);