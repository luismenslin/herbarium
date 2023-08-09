package br.com.univille.herbarium.controller.domain.locacao;

import br.com.univille.herbarium.controller.domain.aluno.AlunoRepository;
import br.com.univille.herbarium.controller.domain.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("locarLivro")
public class LocacaoController {

    @Autowired
    private LocacaoRepository repository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public String showLocarLivro(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        model.addAttribute("alunos", alunoRepository.findAll());

        return "/livros/locarLivro";
    }

    @PostMapping
    public String locarLivro(DadosLocacaoLivro dados) {
        var locacao = new Locacao(dados);
        var livro = livroRepository.getReferenceById(dados.idLivro());
        livro.atualizaStatus("LOCADO");
        repository.save(locacao);
        return "redirect:livros";

    }

    @GetMapping("devolucao")
    public String showDevolucao() {
        return "/livros/devolveLivro";
    }

    @PostMapping("devolucao")
    public String devolveLivro(DadosDevolucaoLivro dados){
        return "redirect:livros";
    }
}
