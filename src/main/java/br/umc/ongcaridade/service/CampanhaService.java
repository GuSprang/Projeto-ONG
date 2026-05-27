package br.umc.ongcaridade.service;

import br.umc.ongcaridade.entity.Campanha;
import br.umc.ongcaridade.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public void cadastrar(Campanha campanha) throws Exception {
        campanhaRepository.cadastrarCampanha(campanha);
    }

    public Campanha buscarPorId(String id) throws Exception {
        Campanha c = campanhaRepository.buscarPorId(id);
        if (c == null) throw new RuntimeException("Campanha nao encontrada");
        return c;
    }

    public List<Campanha> listarTodas() throws Exception {
        return campanhaRepository.listarTodas();
    }

    public void atualizar(String id, Campanha campanha) throws Exception {
        campanhaRepository.atualizar(id, campanha);
    }

    public void deletar(String id) throws Exception {
        campanhaRepository.deletar(id);
    }
}
