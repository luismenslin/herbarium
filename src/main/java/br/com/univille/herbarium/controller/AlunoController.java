package br.com.univille.herbarium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cadastroAluno")
public class AlunoController {

    @GetMapping
    public String showCadastroAluno() {
        return "/cadastroAluno";
    }
}
