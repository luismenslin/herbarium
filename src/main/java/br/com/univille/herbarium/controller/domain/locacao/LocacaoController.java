package br.com.univille.herbarium.controller.domain.locacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("locarLivro")
public class LocacaoController {

    @Autowired
    private LocacaoRepository repository;

    @GetMapping
    public String showLocarLivro() {
        return "/livros/locarLivro";
    }

    @PostMapping
    public String locarLivro(DadosLocacaoLivro dados) {
        var locacao = new Locacao(dados);
        repository.save(locacao);

        return "/livros/locarLivro";
    }
}
