package br.umc.ongcaridade.service;

import br.umc.ongcaridade.entity.doacao.Doacao;
import br.umc.ongcaridade.entity.doacao.DoacaoComNotificacao;
import br.umc.ongcaridade.entity.doacao.DoacaoComRecibo;
import br.umc.ongcaridade.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public void realizar(Doacao doacao) throws Exception {
        Doacao decorada = new DoacaoComNotificacao(new DoacaoComRecibo(doacao));
        System.out.println(decorada.detalhes());
        doacaoRepository.cadastrar(decorada);
    }

    public List<Doacao> listarPorDoador(String doadorId) throws Exception {
        return doacaoRepository.listarPorDoador(doadorId);
    }

    public List<Doacao> listarPorCampanha(String campanhaId) throws Exception {
        return doacaoRepository.listarPorCampanha(campanhaId);
    }
}
