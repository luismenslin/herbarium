package br.com.univille.herbarium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastroLivro")
public class LivroController {

    @GetMapping
    public String showCadastroLivro() {
        return "/cadastroLivro";
    }
}
