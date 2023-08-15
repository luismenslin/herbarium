package br.com.univille.herbarium.controller.domain.locacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("locacoes")
public class LocacaoController {

    @GetMapping
    public String showLocacoes() {
        return "/livros/listagemLocacoes";
    }
}
