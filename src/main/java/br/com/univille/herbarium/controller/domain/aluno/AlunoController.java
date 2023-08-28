package br.com.univille.herbarium.controller.domain.aluno;

import br.com.univille.herbarium.controller.domain.locacao.LocacaoRepository;
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

    @Autowired
    private LocacaoRepository locacaoRepository;

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
        var locacoes = locacaoRepository.findAll();
        for (int i = 0;i < locacoes.size();i++) {
            if (locacoes.get(i).getAluno().getId() == id) {
                locacaoRepository.deleteById(locacoes.get(i).getId());
            }
        }
        repository.deleteById(id);
        return "redirect:alunos";
    }

}
