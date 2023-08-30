CREATE DATABASE herbario;

USE herbario;

CREATE TABLE `alunos` (
  `id` int AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `celular` varchar(30) NOT NULL,
  `curso` varchar(50) NOT NULL,
  `fase` int DEFAULT NULL,
  CONSTRAINT `PK_Alunos` PRIMARY KEY (`id`)
);

CREATE TABLE `livros` (
  `id` int AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `edicao` varchar(50) DEFAULT NULL,
  `publicacao` int DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  CONSTRAINT `PK_Livros` PRIMARY KEY (`id`)
);

CREATE TABLE `locacoes` (
  `id` int AUTO_INCREMENT,
  `aluno` int NOT NULL,
  `livro` int NOT NULL,
  `locacao` date NOT NULL,
  `devolucao` date DEFAULT NULL,
  CONSTRAINT `PK_Locacoes` PRIMARY KEY (`id`),
  CONSTRAINT `FK_Locacoes_Alunos` FOREIGN KEY (`aluno`) REFERENCES `alunos` (`id`),
  CONSTRAINT `FK_Locacoes_Livros` FOREIGN KEY (`livro`) REFERENCES `livros` (`id`)
);