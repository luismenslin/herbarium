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

    public Locacao(Aluno aluno, Livro livro) {
        this.aluno = aluno;
        this.livro = livro;
        this.locacao = LocalDate.now();
    }

    public Locacao() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getLocacao() {
        return locacao;
    }

    public void setLocacao(LocalDate locacao) {
        this.locacao = locacao;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
    }
}
