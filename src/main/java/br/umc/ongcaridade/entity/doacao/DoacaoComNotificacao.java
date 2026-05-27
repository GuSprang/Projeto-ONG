package br.umc.ongcaridade.entity.doacao;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoacaoComNotificacao extends DoacaoDecorator {
    public DoacaoComNotificacao(Doacao wrapped) { super(wrapped); }

    @Override
    public String detalhes() {
        return wrapped.detalhes() + " | Notificacao enviada.";
    }
}
