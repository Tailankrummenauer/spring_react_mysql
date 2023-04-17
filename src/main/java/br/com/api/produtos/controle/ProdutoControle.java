package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController //Spring ja sabe que é o arquivo responsavel por criar rotas


public class ProdutoControle {

    @Autowired ProdutoServico ps;


    //--> metodo responsavel para cadastrar produtos
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrar(pm);
    }

    //--> metodo para listar os produtosModelos
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    @GetMapping("/") //--> para dizer que é do tipo GET com a rota (/)
    public String rota(){
        return "API de produtos funcionando";
    }


    
}
