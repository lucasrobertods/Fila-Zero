package br.com.filazero.domain.model

import java.io.Serializable

data class Produto(
    val nome: String,
    val descricao: String,
    val imagem: String,
    val preco: Double,
    val categoria: String,
) : Serializable {
    fun toUi() = this
}