package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController //Spring ja sabe que é o arquivo responsavel por criar rotas

@CrossOrigin(origins = "*") //--> deixa qualquer porta acessar as requisições 
public class ProdutoControle {

    @Autowired ProdutoServico ps;


    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long codigo){
        return ps.remover(codigo);
    }

    //--> metodo responsavel para cadastrar produtos
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){ //cria um objeto produto modelo PM
        return ps.cadastrarAlterar(pm, "cadastrar");
    }


    //--> metodo responsavel para alterar produtos
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
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
