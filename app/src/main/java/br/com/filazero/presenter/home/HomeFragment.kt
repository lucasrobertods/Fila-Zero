package br.com.filazero.presenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.filazero.R
import br.com.filazero.databinding.FragmentHomeBinding
import br.com.filazero.domain.model.Produto
import br.com.filazero.presenter.cart.CartManager
import br.com.filazero.presenter.home.adapter.CardapioAdapter
import br.com.filazero.presenter.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by sharedViewModel()
    private var _binding: FragmentHomeBinding? = null

    private var produtoList = listOf<Produto>()

    private val binding get() = _binding!!

    private val adapter: CardapioAdapter by lazy {
        CardapioAdapter().apply {
            onItemClick = {
                CartManager.listaCarrinho.add(it)
                Toast.makeText(context, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun handleObservers() {
        homeViewModel.produtos.observe(viewLifecycleOwner) {
            produtoList = it
            updateProdutList()
        }
    }

    private fun updateProdutList() {
        adapter.listaProduto = produtoList
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        handleObservers()
        refreshProdutos()
        setupSpinner()
    }

    private fun refreshProdutos() {
        homeViewModel.getProdutos()
    }

    private fun setupSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.product_filter,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerProductFilter.adapter = adapter
        }
        binding.spinnerProductFilter.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val categoryArray =
                        resources.getStringArray(R.array.product_filter)
                    if (p2 == 0) adapter.listaProduto = produtoList
                    else adapter.listaProduto = produtoList.filter {
                        it.categoria == categoryArray[p2]
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}