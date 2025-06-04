

CREATE TABLE IF NOT EXISTS Libro(
    numero INT NOT NULL,
    titulo VARCHAR(50) NOT NULL UNIQUE,
    clasificacion VARCHAR(50),
    tema VARCHAR(20),
    PRIMARY KEY(numero)
    );

CREATE TABLE IF NOT EXISTS Autor(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    PRIMARY KEY (id)
    );



