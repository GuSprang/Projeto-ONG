package br.umc.ongcaridade.entity.doacao;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoacaoComRecibo extends DoacaoDecorator {
    public DoacaoComRecibo(Doacao wrapped) { super(wrapped); }

    @Override
    public String detalhes() {
        return wrapped.detalhes() + " | Recibo gerado.";
    }
}