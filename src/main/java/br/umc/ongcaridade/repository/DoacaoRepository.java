package br.umc.ongcaridade.repository;

import br.umc.ongcaridade.entity.doacao.Doacao;
import br.umc.ongcaridade.entity.doacao.DoacaoFinanceira;
import br.umc.ongcaridade.entity.doacao.ItemDoado;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DoacaoRepository {

    public void cadastrar(Doacao doacao) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> dados = new HashMap<>();
        dados.put("data", doacao.getData().toString());
        dados.put("doadorId", doacao.getDoadorId());
        dados.put("campanhaId", doacao.getCampanhaId());
        dados.put("detalhes", doacao.detalhes());

        if (doacao instanceof DoacaoFinanceira df) {
            dados.put("tipo", "FINANCEIRA");
            dados.put("valor", df.getValor());
            dados.put("metodoPagamento", df.getMetodoPagamento());
        } else if (doacao instanceof ItemDoado item) {
            dados.put("tipo", "ITEM");
            dados.put("descricao", item.getDescricao());
            dados.put("valorEstimado", item.getValorEstimado());
            dados.put("categoria", item.getCategoria());
        }

        db.collection("doacoes").add(dados).get();
    }

    public List<Doacao> listarPorDoador(String doadorId) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        QuerySnapshot resultado = db.collection("doacoes")
                .whereEqualTo("doadorId", doadorId).get().get();

        List<Doacao> lista = new ArrayList<>();
        for (QueryDocumentSnapshot doc : resultado) lista.add(montarDoacao(doc));
        return lista;
    }

    public List<Doacao> listarPorCampanha(String campanhaId) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        QuerySnapshot resultado = db.collection("doacoes")
                .whereEqualTo("campanhaId", campanhaId).get().get();

        List<Doacao> lista = new ArrayList<>();
        for (QueryDocumentSnapshot doc : resultado) lista.add(montarDoacao(doc));
        return lista;
    }

    private Doacao montarDoacao(QueryDocumentSnapshot doc) {
        String tipo = doc.getString("tipo");
        Doacao doacao;

        if ("FINANCEIRA".equals(tipo)) {
            DoacaoFinanceira df = new DoacaoFinanceira();
            df.setValor(BigDecimal.valueOf(doc.getDouble("valor")));
            df.setMetodoPagamento(doc.getString("metodoPagamento"));
            doacao = df;
        } else {
            ItemDoado item = new ItemDoado();
            item.setDescricao(doc.getString("descricao"));
            item.setValorEstimado(BigDecimal.valueOf(doc.getDouble("valorEstimado")));
            item.setCategoria(doc.getString("categoria"));
            doacao = item;
        }

        doacao.setId(doc.getId());
        doacao.setData(LocalDate.parse(doc.getString("data")));
        doacao.setDoadorId(doc.getString("doadorId"));
        doacao.setCampanhaId(doc.getString("campanhaId"));
        return doacao;
    }
}
