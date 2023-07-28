package br.com.univille.herbarium.controller;

import br.com.univille.herbarium.controller.domain.Aluno;
import br.com.univille.herbarium.controller.domain.AlunoRepository;
import br.com.univille.herbarium.controller.domain.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public String showListagemAlunos(Model model) {
        model.addAttribute("alunos", repository.findAll());
        return "listagemAlunos";
    }

    @PostMapping
    public String cadastraAlunoNovo(DadosCadastroAluno dados) {
        var aluno = new Aluno(dados);
        repository.save(aluno);

        return "redirect:alunos";
    }
    @GetMapping("/cadastroAluno")
    public String showCadastroAluno() {
        return "cadastroAluno";
    }
}
