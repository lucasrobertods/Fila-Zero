package br.com.filazero.ui.home.cart

import br.com.filazero.model.Produto

object CartManager {

    var listaCarrinho: MutableList<Produto> = mutableListOf()

    fun getAmount() = listaCarrinho.sumOf {
        it.preco
    }

}