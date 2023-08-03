package br.com.univille.herbarium.controller.domain.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public String showListagemAlunos(Model model) {
        model.addAttribute("alunos", repository.findAll());
        return "/alunos/listagemAlunos";
    }

    @PostMapping
    @Transactional
    public String cadastraAlunoNovo(DadosCadastroAluno dados) {
        var aluno = new Aluno(dados);
        repository.save(aluno);

        return "redirect:alunos";
    }
    @GetMapping("/cadastroAluno")
    public String showCadastroAluno(Long id, Model model) {
        if (id != null) {
            var aluno = repository.getReferenceById(id);
            model.addAttribute("aluno", aluno);
        }

        return "/alunos/cadastroAluno";
    }

    @PutMapping
    @Transactional
    public String atualizaCadastroAluno(DadosAlteradosAluno dados) {
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizaAluno(dados);

        return "redirect:alunos";
    }

    @DeleteMapping
    @Transactional
    public String deletaAluno(Long id) {
        repository.deleteById(id);
        return "redirect:alunos";
    }

}
