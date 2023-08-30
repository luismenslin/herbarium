package br.com.univille.herbarium.controller.domain.locacao;

import br.com.univille.herbarium.controller.domain.aluno.AlunoRepository;
import br.com.univille.herbarium.controller.domain.livro.LivroController;
import br.com.univille.herbarium.controller.domain.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/locarLivro")
    public String showLocarLivro(Model model) {
        model.addAttribute("livros",livroRepository.findAll());
        model.addAttribute("alunos",alunoRepository.findAll());
        return "/livros/locarLivro";
    }

    @PostMapping("/locarLivro")
    public String locarLivro(DadosLocacaoLivro dados) {
        var aluno = alunoRepository.getReferenceById(dados.idAluno());
        var livro = livroRepository.getReferenceById(dados.idLivro());
        var locacao = new Locacao(aluno,livro);
        livro.atualizaStatus("LOCADO");
        repository.save(locacao);
        return "redirect:/livros";
    }

    @GetMapping("/devolverLivro")
    public String showDevolverLivro(Long idLivro, Model model) {
        var locacoes = repository.findAll();
        Locacao locacao = null;
        for (int i = 0; i < locacoes.size();i++) {
            if (locacoes.get(i).getLivro().getId() == idLivro && locacoes.get(i).getDevolucao() == null) {
                locacao = locacoes.get(i);
            }
        }
        model.addAttribute("locacao",locacao);
        return "/livros/devolverLivro";
    }

    @PostMapping("/devolverLivro")
    public String devolverLivro(DadosDevolucaoLivro dados) {
        var locacao = repository.getReferenceById(dados.locacao());
        locacao.getLivro().atualizaStatus("DISPONIVEL");
        locacao.devolveLivro(dados);
        repository.save(locacao);

        return "redirect:/livros";
    }

}
