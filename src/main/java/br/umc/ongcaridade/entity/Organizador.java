package br.umc.ongcaridade.entity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Organizador extends Pessoa {

    private String  registroOng;
    private boolean verificado;

    public void criarCampanha()    {}
    public void gerenciarCampanha(){}
    public void validarDoacao()    {}
}
