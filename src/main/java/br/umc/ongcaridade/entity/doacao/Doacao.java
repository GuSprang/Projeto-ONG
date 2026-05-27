package br.umc.ongcaridade.entity.doacao;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Doacao {
    private String id;
    private LocalDate data;
    private String doadorId;
    private String campanhaId;

    public abstract String detalhes();
}