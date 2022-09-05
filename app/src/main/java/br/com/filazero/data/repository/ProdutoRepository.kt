package br.com.filazero.data.repository

import br.com.filazero.data.api.ProdutoApi
import br.com.filazero.domain.model.Produto
import br.com.filazero.data.response.toModel
import java.lang.Exception

class ProdutoRepositoryImpl(
    private val produtApi: ProdutoApi
) : ProdutoRepository {

    override suspend fun getProdutos(): List<Produto> {
        val result = produtApi.getProdutos()

        return if(result.isSuccessful) {
            result.body()?.map {
                it.toModel()
            } ?: throw Exception()
        } else {
            throw Exception()
        }
    }

}

interface ProdutoRepository {
    suspend fun getProdutos(): List<Produto>
}