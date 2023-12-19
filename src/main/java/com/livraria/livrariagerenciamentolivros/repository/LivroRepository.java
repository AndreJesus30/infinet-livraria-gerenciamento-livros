
package com.livraria.livrariagerenciamentolivros.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.livraria.livrariagerenciamentolivros.model.Livro;

@Repository 
public interface LivroRepository extends MongoRepository<Livro, String> {

    
}