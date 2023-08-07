package br.com.univille.herbarium.controller.domain.locacao;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Locacao")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer livro;
    private Integer aluno;
    private LocalDate locacao;
    private LocalDate devolucao;

    public Locacao(DadosLocacaoLivro dados) {
        this.livro = dados.idLivro();
        this.aluno = dados.idAluno();
        this.locacao = LocalDate.now();
    }

    public Locacao() {}
    public Integer getLivro() {
        return livro;
    }

    public void setLivro(Integer livro) {
        this.livro = livro;
    }

    public Integer getAluno() {
        return aluno;
    }

    public void setAluno(Integer aluno) {
        this.aluno = aluno;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "livro=" + livro +
                ", aluno=" + aluno +
                ", locacao=" + locacao +
                ", devolucao=" + devolucao +
                '}';
    }
}
