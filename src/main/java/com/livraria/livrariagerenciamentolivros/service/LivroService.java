package com.livraria.livrariagerenciamentolivros.service;
import java.util.List;
import com.livraria.livrariagerenciamentolivros.model.Livro;

public interface LivroService {

    List<Livro> getAll();

    Livro create(Livro livro);

    void deleteById(String id);

    Livro update(String id, Livro livro);

    Livro getById(String id);

}
