package br.com.univille.herbarium.controller.domain.locacao;

import java.time.LocalDate;

public record DadosCadastroLocacao (Long idAluno, Long idLivro, LocalDate locacao) {
}
