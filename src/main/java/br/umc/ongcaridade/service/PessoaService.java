package br.umc.ongcaridade.service;

import br.umc.ongcaridade.entity.Pessoa;
import br.umc.ongcaridade.repository.PessoaRepository;
import br.umc.ongcaridade.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public void cadastrar(Pessoa pessoa) throws Exception {
        pessoaRepository.cadastrar(pessoa);
    }

    public String login(String email, String senha) throws Exception {
        Pessoa pessoa = pessoaRepository.buscarPorEmail(email);
        if (pessoa == null || !pessoa.getSenha().equals(senha)) {
            throw new RuntimeException("Credenciais invalidas");
        }
        return jwtUtil.gerarToken(email);
    }
}
