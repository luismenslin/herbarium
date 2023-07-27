package br.com.univille.herbarium.controller.domain;

public class Aluno {
    private String nome;
    private String celular;
    private String curso;
    private Integer fase;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nomeAluno();
        this.celular = dados.celular();
        this.curso = dados.curso();
        this.fase = dados.fase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", curso='" + curso + '\'' +
                ", fase=" + fase +
                '}';
    }
}
