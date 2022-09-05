package br.com.filazero.presenter.cart

import br.com.filazero.domain.model.Produto

object CartManager {

    var listaCarrinho: MutableList<Produto> = mutableListOf()

    fun getAmount() = listaCarrinho.sumOf {
        it.preco
    }

}