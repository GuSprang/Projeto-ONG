package br.umc.ongcaridade.entity.doacao;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ItemDoado extends DoacaoBase {
    private String descricao;
    private BigDecimal valorEstimado;
    private String categoria;

    @Override
    public String detalhes() {
        return super.detalhes() + " | Item: " + descricao + " (R$" + valorEstimado + ")";
    }
    // getters e setters
}
