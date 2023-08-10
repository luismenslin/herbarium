package br.com.univille.herbarium.controller.domain.locacao;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long aluno;

    private Long livro;

    private LocalDate locacao;
    private LocalDate devolucao;

    public Locacao() {}

    public Locacao(DadosCadastroLocacao dados) {
        this.aluno = dados.idAluno();
        this.livro = dados.idLivro();
        this.locacao = dados.locacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAluno() {
        return aluno;
    }

    public void setAluno(Long idAluno) {
        this.aluno = idAluno;
    }

    public Long getLivro() {
        return livro;
    }

    public void setLivro(Long idLivro) {
        this.livro = idLivro;
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

    @Override
    public String toString() {
        return "Locacao{" +
                "id=" + id +
                ", idAluno=" + aluno +
                ", idLivro=" + livro +
                ", locacao=" + locacao +
                ", devolucao=" + devolucao +
                '}';
    }
}
