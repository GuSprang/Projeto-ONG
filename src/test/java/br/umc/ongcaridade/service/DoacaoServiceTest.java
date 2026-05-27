package br.umc.ongcaridade.service;

import br.umc.ongcaridade.entity.doacao.Doacao;
import br.umc.ongcaridade.entity.doacao.DoacaoFinanceira;
import br.umc.ongcaridade.repository.DoacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DoacaoServiceTest {

    @Mock
    DoacaoRepository doacaoRepository;

    @InjectMocks
    DoacaoService doacaoService;

    @Test
    void deveRealizarDoacaoComDecorators() throws Exception {
        DoacaoFinanceira doacao = new DoacaoFinanceira();
        doacao.setId("d1");
        doacao.setData(LocalDate.now());
        doacao.setDoadorId("p1");
        doacao.setCampanhaId("c1");
        doacao.setValor(new BigDecimal("100.00"));
        doacao.setMetodoPagamento("PIX");

        doacaoService.realizar(doacao);

        verify(doacaoRepository, times(1)).cadastrar(any(Doacao.class));
    }
}
