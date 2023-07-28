package br.com.univille.herbarium.controller.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ALUNOS")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String celular;
    private String curso;
    private Integer fase;

    public Aluno (DadosCadastroAluno dados) {
        this.nomeCompleto = dados.nomeCompleto();
        this.celular = dados.celular();
        this.curso = dados.curso();
        this.fase = dados.fase();
    }

    public Aluno() {}
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", celular='" + celular + '\'' +
                ", curso='" + curso + '\'' +
                ", fase=" + fase +
                '}';
    }
}
