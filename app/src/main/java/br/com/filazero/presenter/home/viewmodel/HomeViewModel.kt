package br.com.filazero.presenter.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.filazero.domain.model.Produto
import br.com.filazero.domain.usecase.GetProdutoUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProdutoUseCase: GetProdutoUseCase
) : ViewModel() {

    private val _produtos = MutableLiveData<List<Produto>>()
    val produtos: LiveData<List<Produto>> = _produtos

    fun getProdutos() {
        viewModelScope.launch {
            val produtoList = getProdutoUseCase()

            _produtos.value = produtoList.map {
                it.toUi()
            }
        }
    }

}