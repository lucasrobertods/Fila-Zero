package br.com.filazero.ui.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.filazero.R
import br.com.filazero.databinding.FragmentHomeBinding
import br.com.filazero.model.Produto
import br.com.filazero.ui.home.home.adapter.CardapioAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val adapter: CardapioAdapter by lazy {
        CardapioAdapter()
    }

    var lista = listOf(
        Produto(
            "Produto 1",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Bebidas"
        ),
        Produto(
            "Produto 2",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Comidas"
        ),
        Produto(
            "Produto depois do 2",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Sobremesas"
        ), Produto(
            "Produto 3",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Bebidas"
        ),
        Produto(
            "Produto 4",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Comidas"
        ),
        Produto(
            "Produto 5",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Sobremesas"
        ), Produto(
            "Produto 6",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Bebidas"
        ),
        Produto(
            "Produto 7",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Comidas"
        ),
        Produto(
            "Produto 8",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Sobremesas"
        ),
        Produto(
            "Produto 9",
            "Descricao do produto 1",
            "https://www.refrescofit.com.br/wp-content/uploads/2018/08/Como-decorar-bebidas-mais-bonitas-1030x686.jpg",
            "R$ 19,99",
            "Sobremesas"
        )
    )

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

    private fun setupView() {
        binding.recyclerView.adapter = adapter
        adapter.listaProduto = lista
        setupSpinner()
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
                    if (p2 == 0) adapter.listaProduto = lista
                    else adapter.listaProduto = lista.filter {
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