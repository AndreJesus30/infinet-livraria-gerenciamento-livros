package com.livraria.livrariagerenciamentolivros.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.livrariagerenciamentolivros.exception.LivroNotFoundException;
import com.livraria.livrariagerenciamentolivros.model.Livro;
import com.livraria.livrariagerenciamentolivros.payload.ResponsePayload;
import com.livraria.livrariagerenciamentolivros.service.LivroService;

@RestController
@RequestMapping("/")
public class LivroController {
    
    @Autowired
    LivroService livroService;

    Logger LOGGER = LoggerFactory.getLogger(LivroController.class);

    @GetMapping
    public List<Livro> getAll(){
        List<Livro> all = livroService.getAll();
        LOGGER.info("GET ALL:" + all);
        return all;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try{
            Livro livro = livroService.getById(id);
            LOGGER.info("GET BY ID: "+ livro);
            return ResponseEntity.ok(livro);
        }catch (LivroNotFoundException ex){
            ResponsePayload notFound = ResponsePayload.builder().message("Not Found").dateTime(LocalDateTime.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        LOGGER.info("DELETE: " + id);
        livroService.deleteById(id);
    }
    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        Livro created = livroService.create(livro);
        LOGGER.info("CREATED: " + created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Livro livro){
        Livro updated = livroService.update(id, livro);
        LOGGER.info("UPDATE: " + updated);
    }

}
