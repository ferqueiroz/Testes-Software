package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercício 1 — integração Service + Repository + H2 (sem mocks).
 */
@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Envia as alterações pendentes ao banco (flush) e esvazia o cache da
     * sessão (clear). Assim, o próximo findById() é obrigado a consultar o
     * H2 de verdade, em vez de devolver o mesmo objeto que já está em memória.
     */
    private void forcarIdaAoBanco() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @DisplayName("CT01 — Cadastro válido")
    void deveCadastrarERecuperarProduto() {
        Produto salvo = service.cadastrar("Teclado", 150.0);

        assertNotNull(salvo.getId(), "O produto cadastrado deve receber um ID");

        forcarIdaAoBanco();

        Produto encontrado = repository.findById(salvo.getId()).orElseThrow();
        assertEquals("Teclado", encontrado.getNome());
        assertEquals(150.0, encontrado.getPreco(), 0.001);
    }

    @Test
    @DisplayName("CT02 — Nome inválido")
    void naoDevePersistirProdutoComNomeEmBranco() {
        long antes = repository.count();

        assertThrows(IllegalArgumentException.class,
                () -> service.cadastrar("   ", 80.0));

        assertEquals(antes, repository.count(),
                "Nenhum registro deve ser criado quando o nome é inválido");
    }

    @Test
    @DisplayName("CT03 — Atualização de preço (desafio)")
    void deveAtualizarPrecoPersistido() {
        Produto salvo = service.cadastrar("Mouse", 80.0);

        service.atualizarPreco(salvo.getId(), 95.0);

        forcarIdaAoBanco();

        Produto atualizado = repository.findById(salvo.getId()).orElseThrow();
        assertEquals(95.0, atualizado.getPreco(), 0.001);
    }

    // ---------- Casos extras: validações que o serviço já faz ----------

    @ParameterizedTest(name = "preço {0} é recusado")
    @ValueSource(doubles = {0.0, -10.0})
    @DisplayName("CT06 — Preço zero ou negativo não é gravado")
    void naoDevePersistirProdutoComPrecoInvalido(double precoInvalido) {
        long antes = repository.count();

        assertThrows(IllegalArgumentException.class,
                () -> service.cadastrar("Teclado", precoInvalido));

        assertEquals(antes, repository.count(),
                "Nenhum registro deve ser criado quando o preço é inválido");
    }

    @Test
    @DisplayName("CT07 — Buscar um ID que não existe")
    void deveFalharAoBuscarProdutoInexistente() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> service.buscar(999_999L));

        assertEquals("Produto não encontrado", erro.getMessage());
    }

    @Test
    @DisplayName("CT08 — Atualização com preço inválido mantém o preço antigo no banco")
    void naoDeveAtualizarParaPrecoInvalido() {
        Produto salvo = service.cadastrar("Mouse", 80.0);
        forcarIdaAoBanco();

        assertThrows(IllegalArgumentException.class,
                () -> service.atualizarPreco(salvo.getId(), -1.0));

        forcarIdaAoBanco();
        Produto naoMudou = repository.findById(salvo.getId()).orElseThrow();
        assertEquals(80.0, naoMudou.getPreco(), 0.001);
    }
}
