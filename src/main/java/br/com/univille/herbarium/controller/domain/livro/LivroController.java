package br.com.univille.herbarium.controller.domain.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;
    @GetMapping
    public String showAcervo(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livros/listagemLivros";
    }

    @PostMapping
    public String cadastraLivroNovo(DadosCadastroLivro dados) {
        var Livro = new Livro(dados);
        repository.save(Livro);

        return "redirect:livros";
    }


    @GetMapping("/cadastroLivro")
    public String showCadastroLivro() {
        return "livros/cadastroLivro";
    }

    @DeleteMapping
    public String removeLivro(Long id) {
        repository.deleteById(id);
        return "redirect:livros";
    }
}
