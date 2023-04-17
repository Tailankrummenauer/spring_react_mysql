package br.com.api.produtos.modelo;
//duas medias para criar a tabela e a outra para colcoar o nome da tabela, se nao ele pega o nome da class

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "produtos")

//faz por baixo dos panos a inclusão de getter e setter via extensao lombok
@Getter 
@Setter

public class ProdutoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // faz o autoincremento de id e chave primaria
    private Long codigo;
    private String nome;
    private String marca;


}
