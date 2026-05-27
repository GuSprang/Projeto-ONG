package br.umc.ongcaridade.entity.doacao;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public abstract class Doacao {
    private String id;
    private LocalDate data;
    private String doadorId;
    private String campanhaId;

    public abstract String detalhes();
}