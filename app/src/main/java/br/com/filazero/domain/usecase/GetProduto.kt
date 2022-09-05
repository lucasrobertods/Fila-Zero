package br.com.filazero.domain.usecase

import br.com.filazero.data.repository.ProdutoRepository
import br.com.filazero.domain.model.Produto
import java.lang.Exception

class GetProduto (
    private val produtoRepository: ProdutoRepository
): GetProdutoUseCase {

    override suspend fun invoke(): List<Produto> = try {
        produtoRepository.getProdutos()
    } catch (e : Exception) {
        var exception = e
        listOf()
    }

}

interface GetProdutoUseCase {
    suspend operator fun invoke(): List<Produto>
}