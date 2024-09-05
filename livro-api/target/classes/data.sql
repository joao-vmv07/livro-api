CREATE TABLE tb_livro (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    titulo VARCHAR(35) NOT NULL,
    autor VARCHAR(35) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    ano_publicacao INT NOT NULL
);

-- Inserindo registros na tabela 'tb_livro'
INSERT INTO tb_livro (ano_publicacao, autor, isbn, titulo) 
VALUES (1899, 'Machado de Assis', '9788535902777', 'Dom Casmurro');

INSERT INTO tb_livro (ano_publicacao, autor, isbn, titulo) 
VALUES (1988, 'Paulo Coelho', '9788501066791', 'O Alquimista');

INSERT INTO tb_livro (ano_publicacao, autor, isbn, titulo) 
VALUES (1956, 'João Guimarães Rosa', '9788506051305', 'Grande Sertão: Veredas');

INSERT INTO tb_livro (ano_publicacao, autor, isbn, titulo) 
VALUES (1938, 'Graciliano Ramos', '9788535907253', 'Vidas Secas');

INSERT INTO tb_livro (ano_publicacao, autor, isbn, titulo) 
VALUES (1881, 'Machado de Assis', '9788535902821', 'Memórias Póstumas de Brás Cubas');