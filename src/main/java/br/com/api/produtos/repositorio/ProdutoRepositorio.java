package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelo.ProdutoModelo;

@Repository  //--> avisa que para o spring que este arquivo é um repositorio, podendo futuramente usar injeção de dependencia

public interface ProdutoRepositorio  extends CrudRepository<ProdutoModelo, Long>{
    
}
