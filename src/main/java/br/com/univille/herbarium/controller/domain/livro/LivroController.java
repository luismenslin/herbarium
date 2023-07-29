package br.com.univille.herbarium.controller.domain.livro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livros")
public class LivroController {

    @GetMapping
    public String showAcervo() {
        return "livros/listagemLivros";
    }



    @GetMapping("/listagemLivros")
    public String showListagemLivros() {
        return "livros/listagemLivros";
    }
}
