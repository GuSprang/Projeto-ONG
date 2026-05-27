package br.umc.ongcaridade.security;

import br.umc.ongcaridade.entity.Pessoa;
import br.umc.ongcaridade.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Pessoa pessoa = pessoaRepository.buscarPorEmail(email);
            if (pessoa == null) throw new UsernameNotFoundException("Usuario nao encontrado");
            return User.builder()
                    .username(pessoa.getEmail())
                    .password(pessoa.getSenha())
                    .roles(pessoa.getPerfil())
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("Erro ao buscar usuario");
        }
    }
}

