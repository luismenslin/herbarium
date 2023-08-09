package br.com.univille.herbarium.controller.domain.locacao;

import java.time.LocalDate;

public record DadosDevolucaoLivro (Long idLivro, Long idAluno, LocalDate data) {}
