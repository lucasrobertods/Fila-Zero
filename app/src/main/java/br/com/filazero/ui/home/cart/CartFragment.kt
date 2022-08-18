package br.com.filazero.ui.home.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.filazero.R
import br.com.filazero.databinding.FragmentCartBinding
import br.com.filazero.extensions.toCurrency
import br.com.filazero.ui.home.cart.adapter.CartAdapter

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

    private val binding get() = _binding!!

    private val adapter: CartAdapter by lazy {
        CartAdapter().apply {
            onItemClick = {
                CartManager.listaCarrinho.remove(it)
                Toast.makeText(context, "Removido com sucesso!", Toast.LENGTH_SHORT).show()
                updateList()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    private fun updateList() {
        adapter.listaCarrinho = CartManager.listaCarrinho
        binding.tvTotal.text = getString(R.string.cart_fragment_total, CartManager.getAmount().toCurrency())
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        binding.btnFinalizar.setOnClickListener {
            CartManager.listaCarrinho = mutableListOf()
            updateList()
            Toast.makeText(context, "Seu pedido está sendo preparado!", Toast.LENGTH_SHORT).show()
        }
        updateList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}