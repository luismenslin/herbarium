package br.com.univille.herbarium.controller.domain.livro;

import br.com.univille.herbarium.controller.domain.locacao.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LocacaoRepository locacaoRepository;

    @GetMapping
    public String showListagemLivros(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livros/listagemLivros";
    }

    @GetMapping("/cadastroLivro")
    public String showCadastroLivro(Long id, Model model) {
        if (id != null) {
            var livro = repository.getReferenceById(id);
            model.addAttribute("livro", livro);
        }

        return "livros/cadastroLivro";
    }



    @PostMapping
    @Transactional
    public String cadastraLivroNovo(DadosCadastroLivro dados) {
        var Livro = new Livro(dados);
        repository.save(Livro);

        return "redirect:livros";
    }


    @PutMapping
    @Transactional
    public String alteraLivro(DadosAlteradosLivro dados) {
        var livro = repository.getReferenceById(dados.id());
        livro.atualizaLivro(dados);

        return "redirect:livros";
    }

    @DeleteMapping
    @Transactional
    public String removeLivro(Long id) {
        var locacoes = locacaoRepository.findAll();
        for (int i = 0;i < locacoes.size();i++) {
            if (locacoes.get(i).getLivro().getId() == id) {
                locacaoRepository.deleteById(locacoes.get(i).getId());
            }
        }
        repository.deleteById(id);

        return "redirect:livros";
    }
}
