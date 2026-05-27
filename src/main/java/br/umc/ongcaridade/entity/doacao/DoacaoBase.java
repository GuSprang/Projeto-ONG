package br.umc.ongcaridade.entity.doacao;

public class DoacaoBase extends Doacao {
    @Override
    public String detalhes() {
        return "Doacao realizada em " + getData() + " para campanha " + getCampanhaId();
    }
}