package br.com.filazero.data.api

import br.com.filazero.data.response.ProdutoResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProdutoApi {

    @GET("produto")
    suspend fun getProdutos(): Response<List<ProdutoResponse>>

    companion object {
        var retrofitService: ProdutoApi? = null
        fun getInstance() : ProdutoApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.15.12:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ProdutoApi::class.java)
            }
            return retrofitService!!
        }

    }

}