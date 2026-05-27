package br.umc.ongcaridade.entity.doacao;

public abstract class DoacaoDecorator extends Doacao {
    protected Doacao wrapped;

    public DoacaoDecorator(Doacao wrapped) {
        this.wrapped = wrapped;
        setId(wrapped.getId());
        setData(wrapped.getData());
        setDoadorId(wrapped.getDoadorId());
        setCampanhaId(wrapped.getCampanhaId());
    }

    @Override
    public String detalhes() {
        return wrapped.detalhes();
    }
}
