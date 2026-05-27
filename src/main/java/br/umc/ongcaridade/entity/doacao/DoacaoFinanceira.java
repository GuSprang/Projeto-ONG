package br.umc.ongcaridade.entity.doacao;

import java.math.BigDecimal;

public class DoacaoFinanceira extends DoacaoBase {
    private BigDecimal valor;
    private String metodoPagamento;

    @Override
    public String detalhes() {
        return super.detalhes() + " | Valor: R$" + valor + " via " + metodoPagamento;
    }
    // getters e setters
}