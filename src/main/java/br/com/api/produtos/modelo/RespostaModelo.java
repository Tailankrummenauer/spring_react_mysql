package br.com.api.produtos.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// vai ser utilizada para retornar um feedback quando acotecer erros na api com cadastro, seleção, alteração, deletar

//-- pode ser utilizada a injeção de dependencia
//deixa por conta do spring a criação de um obj relacionado a classe em si.

@Component 
@Getter
@Setter
public class RespostaModelo {
    private String mensagem;
}   
