package br.umc.ongcaridade.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campanha {

    private String        id;
    private String     nome;
    private String     descricao;
    private LocalDate  dataInicio;
    private LocalDate  dataFim;
    private String     status;
    private Endereco   endereco;
    private String     responsavelLocal;
    private String     contatoResponsavel;
    private int        capacidadePessoas;
    private Organizador organizador;

    public BigDecimal totalizarDoacoesFinanceiras() { return BigDecimal.ZERO; }
    public BigDecimal totalizarItensDoados()        { return BigDecimal.ZERO; }
    public void adicionarMetas()                    {}

}
