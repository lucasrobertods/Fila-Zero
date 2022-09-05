package br.com.filazero.data.response

import br.com.filazero.domain.model.Produto


data class ProdutoResponse(
    val nome: String = "",
    val descricao: String = "",
    val imagem: String = "",
    val preco: String = "",
    val categoria: String = "",
)

fun ProdutoResponse.toModel(): Produto {
    return Produto(
        nome = nome,
        descricao = descricao,
        imagem = imagem,
        preco = preco.toDouble(),
        categoria = categoria,
    )
}
