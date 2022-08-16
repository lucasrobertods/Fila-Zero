package br.com.filazero.ui.home.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.filazero.R
import br.com.filazero.databinding.ItemCardapioBinding
import br.com.filazero.model.Produto
import com.bumptech.glide.Glide

class CardapioAdapter : RecyclerView.Adapter<CardapioAdapter.ProdutoViewHolder>() {

    var listaProduto = listOf(
        Produto(
            "Produto 1",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 2",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto depois do 2",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ), Produto(
            "Produto 3",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 4",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 5",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ), Produto(
            "Produto 6",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 7",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 8",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        ),
        Produto(
            "Produto 9",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardapio, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = listaProduto.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCardapioBinding.bind(itemView)
        fun bind(item: Produto) {
            with(itemView) {
                Glide.with(context).load(item.imagem).into(binding.ivProduct)
                binding.tvName.text = item.nome
                binding.tvDescription.text = item.descricao
                binding.tvPrice.text = item.preco
            }
        }
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(listaProduto[position])
    }

}
