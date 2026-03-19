USE `gerenciamento-produtos`;

CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INT DEFAULT 0
);

INSERT INTO produtos (nome, valor, quantidade) VALUES
('Teclado Mecanico', 250.00, 15),
('Mouse Gamer', 120.50, 30),
('Monitor 24pol', 899.90, 10);