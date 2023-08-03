package br.com.univille.herbarium.controller.domain.locar;

import br.com.univille.herbarium.controller.domain.aluno.AlunoRepository;
import br.com.univille.herbarium.controller.domain.livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("livros")
public class LocarController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    @GetMapping("/locarLivro")
    public String showLocarLivro(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        model.addAttribute("alunos", alunoRepository.findAll());
        return "/livros/locarLivro";
    }

}
