package br.umc.ongcaridade.entity.doacao;

public class DoacaoComNotificacao extends DoacaoDecorator {
    public DoacaoComNotificacao(Doacao wrapped) { super(wrapped); }

    @Override
    public String detalhes() {
        return wrapped.detalhes() + " | Notificacao enviada.";
    }
}
