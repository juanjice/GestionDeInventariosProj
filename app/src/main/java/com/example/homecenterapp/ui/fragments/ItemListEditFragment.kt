package com.example.homecenterapp.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homecenterapp.R
import com.example.homecenterapp.domain.ItemUseCase
import com.example.homecenterapp.model.Item
import com.example.homecenterapp.ui.adapter.ItemAdapter
import com.example.homecenterapp.viewmodel.ItemViewModel
import com.example.homecenterapp.viewmodel.InventarioViewModelFactory
import kotlinx.android.synthetic.main.fragment_item_list.*
import kotlinx.android.synthetic.main.fragment_item_list_edit.*
import kotlinx.android.synthetic.main.fragment_item_list_edit.rvListaInventario

class ItemListEditFragment : Fragment() {

    private lateinit var viewModel: ItemViewModel
    private lateinit var navController: NavController
    private var items: List<Item> = listOf()
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list_edit, container, false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelAndObserve()
        adapter = ItemAdapter(items)
        navController =
            Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
        btnEditarDetalle.setOnClickListener {
            navController.navigate(R.id.action_fourthFragment_to_fifthFragment)

        }
        viewModel.getItems()

    }

    private fun setupViewModelAndObserve() {
        viewModel = ViewModelProvider(this, InventarioViewModelFactory(ItemUseCase()))
            .get(ItemViewModel::class.java)

        val itemsObserver = Observer<List<Item>> {
            adapter = ItemAdapter(it)
            rvListaInventario.adapter = adapter
            val layoutManager = LinearLayoutManager(this@ItemListEditFragment.context)
            rvListaInventario.layoutManager = LinearLayoutManager(this@ItemListEditFragment.context)
            rvListaInventario.addItemDecoration(
                DividerItemDecoration(rvListaInventario.context,
                    layoutManager.orientation
                )
            )
        }
        viewModel.getItemsLiveData().observe(this.requireActivity(), itemsObserver)
    }

}