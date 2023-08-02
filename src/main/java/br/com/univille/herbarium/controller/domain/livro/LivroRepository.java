package br.com.univille.herbarium.controller.domain.livro;

import org.springframework.data.jpa.repository.JpaRepository;
public interface LivroRepository extends JpaRepository <Livro, Long> {
}
