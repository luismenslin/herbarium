package br.com.univille.herbarium.controller;

import br.com.univille.herbarium.controller.domain.Aluno;
import br.com.univille.herbarium.controller.domain.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cadastroAluno")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();


    @GetMapping
    public String showCadastroAluno() {
        return "/cadastroAluno";
    }

    @PostMapping
    public String cadastraNovoAluno(DadosCadastroAluno dados) {
        var aluno = new Aluno(dados);
        alunos.add(aluno);
        System.out.println(alunos);
        return "redirect:/home";
    }
}
