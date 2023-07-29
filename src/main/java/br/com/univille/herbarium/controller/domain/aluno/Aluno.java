package br.com.univille.herbarium.controller.domain.aluno;

import jakarta.persistence.*;

@Entity
@Table(name = "Alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String celular;
    private String curso;
    private Integer fase;

    public Aluno (DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.celular = dados.celular();
        this.curso = dados.curso();
        this.fase = dados.fase();
    }

    public Aluno() {}
    public String getNome() {
        return nome;
    }

    public void setNomeCompleto(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nomeCompleto='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", curso='" + curso + '\'' +
                ", fase=" + fase +
                '}';
    }
}
