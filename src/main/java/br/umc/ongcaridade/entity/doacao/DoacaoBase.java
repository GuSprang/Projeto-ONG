package br.umc.ongcaridade.entity.doacao;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoacaoBase extends Doacao {
    @Override
    public String detalhes() {
        return "Doacao realizada em " + getData() + " para campanha " + getCampanhaId();
    }
}