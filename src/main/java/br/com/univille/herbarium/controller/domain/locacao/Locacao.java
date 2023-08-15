package br.com.univille.herbarium.controller.domain.locacao;

import br.com.univille.herbarium.controller.domain.aluno.Aluno;
import br.com.univille.herbarium.controller.domain.livro.Livro;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Locacoes")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "livro")
    private Livro livro;
    private LocalDate locacao;
    private LocalDate devolucao;


}
