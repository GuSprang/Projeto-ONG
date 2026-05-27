package br.umc.ongcaridade.service;

import br.umc.ongcaridade.entity.Campanha;
import br.umc.ongcaridade.repository.CampanhaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CampanhaServiceTest {

    @Mock
    CampanhaRepository campanhaRepository;

    @InjectMocks
    CampanhaService campanhaService;

    @Test
    void deveBuscarCampanhaPorId() throws Exception {
        Campanha campanha = Campanha.builder().id("123").nome("Teste").build();
        when(campanhaRepository.buscarPorId("123")).thenReturn(campanha);

        Campanha resultado = campanhaService.buscarPorId("123");

        assertEquals("Teste", resultado.getNome());
        verify(campanhaRepository, times(1)).buscarPorId("123");
    }

    @Test
    void deveLancarExcecaoQuandoNaoExiste() throws Exception {
        when(campanhaRepository.buscarPorId("999")).thenReturn(null);
        assertThrows(RuntimeException.class, () -> campanhaService.buscarPorId("999"));
    }
}
