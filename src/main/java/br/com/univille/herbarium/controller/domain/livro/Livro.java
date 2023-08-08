package br.com.univille.herbarium.controller.domain.livro;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;
    private String edicao;
    private Integer publicacao;
    private String status;

    public Livro(DadosCadastroLivro dados) {
        this.nome = dados.nome();
        this.autor = dados.autor();
        this.edicao = dados.edicao();
        this.publicacao = dados.publicacao();
        this.status = "DISPONIVEL";
    }
    public Livro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Integer getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Integer publicacao) {
        this.publicacao = publicacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void atualizaLivro(DadosAlteradosLivro dados) {
        this.nome = dados.nome();
        this.autor = dados.autor();
        this.edicao = dados.edicao();
        this.publicacao = dados.publicacao();
    }
}
