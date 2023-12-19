package com.livraria.livrariagerenciamentolivros.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.livrariagerenciamentolivros.exception.LivroNotFoundException;
import com.livraria.livrariagerenciamentolivros.model.Livro;
import com.livraria.livrariagerenciamentolivros.repository.LivroRepository;
import com.livraria.livrariagerenciamentolivros.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository livroRepository;

    @Override
    public List<Livro> getAll() {
       return livroRepository.findAll();
    }

    @Override
    public Livro create(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void deleteById(String id) {
        livroRepository.deleteById(id);
    }

    @Override
    public Livro update(String id, Livro livro) {
        livro.setId(id);
        return create(livro);
    }

    @Override
    public Livro getById(String id) {
        return livroRepository.findById(id).orElseThrow(LivroNotFoundException::new);
    }
    
}
