select current_database();

CREATE TABLE adotantes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)
);

CREATE TABLE pets (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    sexo VARCHAR(20) NOT NULL CHECK (sexo IN ('MACHO', 'FEMEA')),
    raca VARCHAR(100),
    idade INTEGER CHECK (idade >= 0),
    imagem VARCHAR(255),

    adotante_id INTEGER,

    CONSTRAINT fk_adotante
        FOREIGN KEY (adotante_id)
        REFERENCES adotantes(id)
);

ALTER TABLE pets ADD COLUMN adotante_id INTEGER;

ALTER TABLE pets
ADD CONSTRAINT fk_adotante
FOREIGN KEY (adotante_id) REFERENCES adotantes(id);

INSERT INTO pets (nome, especie, sexo, raca, idade, imagem)
VALUES ('Rex', 'Cachorro', 'MACHO', 'Labrador', 8, 'https://petanjo.com/blog/wp-content/uploads/2021/11/labrador-tudo-sobre-a-raca.jpg');

select * from adotantes;
select * from pets;

UPDATE pets
SET adotante_id = null
WHERE id = 3;

DELETE FROM adotantes WHERE id = 6;
DELETE FROM pets WHERE id = 7;
