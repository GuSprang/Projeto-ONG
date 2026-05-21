package br.umc.ongcaridade.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

    protected String       id;
    protected String    nome;
    protected String    email;
    protected String    senha;
    protected String    documento;
    protected String    perfil;
    protected LocalDate dataNascimento;


    public boolean logar() { return true; }
}
