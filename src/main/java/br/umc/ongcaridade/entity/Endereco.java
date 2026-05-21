package br.umc.ongcaridade.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private String    id;
    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

}