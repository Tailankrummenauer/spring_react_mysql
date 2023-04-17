package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service // -- utilizar injeção de dependencia para criar um obj e ter acesso aos metodos
         // criados nessa classe
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    // Metodo para listar todos produtos
    public Iterable<ProdutoModelo> listar() {
        return pr.findAll();
    }

    // --> metodo responsavel para cadastrar produtos
    public ResponseEntity<?> cadastrar(ProdutoModelo pm) {
        if (pm.getNome().equals("")) {
            rm.setMensagem("O nome do produto é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

        }else if(pm.getMarca().equals("")){
            rm.setMensagem("O nome da marca é obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_GATEWAY);
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        }

    }

}
