package br.umc.ongcaridade.repository;

import br.umc.ongcaridade.entity.Endereco;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnderecoRepository {

    public String cadastrar(Endereco endereco) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> dados = new HashMap<>();
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("cep", endereco.getCep());

        DocumentReference ref = db.collection("enderecos").add(dados).get();
        return ref.getId();
    }

    public void atualizar(String id, Endereco endereco) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> dados = new HashMap<>();
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("cep", endereco.getCep());

        db.collection("enderecos").document(id).set(dados).get();
    }

    public Endereco buscarPorId(String id) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        DocumentSnapshot doc = db.collection("enderecos").document(id).get().get();
        if (!doc.exists()) return null;
        return doc.toObject(Endereco.class);
    }
}