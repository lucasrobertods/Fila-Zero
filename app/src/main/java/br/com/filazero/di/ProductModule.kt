package br.com.filazero.di

import br.com.filazero.data.api.ProdutoApi
import br.com.filazero.data.repository.ProdutoRepository
import br.com.filazero.data.repository.ProdutoRepositoryImpl
import br.com.filazero.domain.usecase.GetProduto
import br.com.filazero.domain.usecase.GetProdutoUseCase
import br.com.filazero.presenter.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    single { ProdutoApi.getInstance() }
    factory<ProdutoRepository> { ProdutoRepositoryImpl(get()) }
    factory<GetProdutoUseCase> { GetProduto(get()) }
    viewModel { HomeViewModel(get()) }
}