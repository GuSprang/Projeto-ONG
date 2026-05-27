package br.umc.ongcaridade.repository;

import br.umc.ongcaridade.entity.Doador;
import br.umc.ongcaridade.entity.Organizador;
import br.umc.ongcaridade.entity.Pessoa;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PessoaRepository {

    public void cadastrar(Pessoa pessoa) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("senha", pessoa.getSenha());
        dados.put("documento", pessoa.getDocumento());
        dados.put("dataNascimento", pessoa.getDataNascimento().toString());
        dados.put("perfil", pessoa instanceof Organizador ? "ORGANIZADOR" : "DOADOR");

        if (pessoa instanceof Organizador org) {
            dados.put("registroOng", org.getRegistroOng());
            dados.put("verificado", org.isVerificado());
        }

        db.collection("pessoas").add(dados).get();
    }

    public Pessoa buscarPorEmail(String email) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        QuerySnapshot resultado = db.collection("pessoas")
                .whereEqualTo("email", email).get().get();

        if (resultado.isEmpty()) return null;

        return montarPessoa(resultado.getDocuments().get(0));
    }

    public Pessoa buscarPorId(String id) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        DocumentSnapshot doc = db.collection("pessoas").document(id).get().get();

        if (!doc.exists()) return null;

        return montarPessoa(doc);
    }

    private Pessoa montarPessoa(DocumentSnapshot doc) {
        String perfil = doc.getString("perfil");

        Pessoa pessoa;
        if ("ORGANIZADOR".equals(perfil)) {
            Organizador org = new Organizador();
            org.setRegistroOng(doc.getString("registroOng"));
            org.setVerificado(Boolean.TRUE.equals(doc.getBoolean("verificado")));
            pessoa = org;
        } else {
            pessoa = new Doador();
        }

        pessoa.setId(doc.getId());
        pessoa.setNome(doc.getString("nome"));
        pessoa.setEmail(doc.getString("email"));
        pessoa.setSenha(doc.getString("senha"));
        pessoa.setDocumento(doc.getString("documento"));
        pessoa.setPerfil(doc.getString("perfil"));
        pessoa.setDataNascimento(LocalDate.parse(doc.getString("dataNascimento")));

        return pessoa;
    }
}