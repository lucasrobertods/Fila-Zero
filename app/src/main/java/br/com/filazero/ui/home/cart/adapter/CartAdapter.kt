package br.com.filazero.ui.home.cart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.filazero.R
import br.com.filazero.databinding.ItemCardapioBinding
import br.com.filazero.extensions.toCurrency
import br.com.filazero.model.Produto
import com.bumptech.glide.Glide

class CartAdapter : RecyclerView.Adapter<CartAdapter.ProdutoViewHolder>() {

    var onItemClick: ((Produto) -> Unit)? = null
    var listaCarrinho = listOf<Produto>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun getItemCount() = listaCarrinho.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCardapioBinding.bind(itemView)
        fun bind(item: Produto) {
            with(itemView) {
                Glide.with(context).load(item.imagem).into(binding.ivProduct)
                binding.tvName.text = item.nome
                binding.tvDescription.text = item.descricao
                binding.tvPrice.text = item.preco.toCurrency()
                setOnClickListener {
                    onItemClick?.invoke(item)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(listaCarrinho[position])
    }

}
