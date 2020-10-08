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
import com.example.homecenterapp.R
import com.example.homecenterapp.domain.ItemUseCase
import com.example.homecenterapp.model.Item
import com.example.homecenterapp.viewmodel.MyViewModel
import com.example.homecenterapp.viewmodel.MyViewModelFactory
import kotlinx.android.synthetic.main.fragment_item_list.*

class ItemListFragment : Fragment() {

    private lateinit var viewModel: MyViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
         container: ViewGroup?,
         savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModelAndObserve()
        navController =
            Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
        btnVerDetalle.setOnClickListener {
            viewModel.getItems()
            navController.navigate(R.id.action_secondFragment_to_thirdFragment)

        }


    }



    private fun setupViewModelAndObserve() {
        viewModel = ViewModelProvider(this,  MyViewModelFactory(ItemUseCase()))
            .get(MyViewModel::class.java)

        val itemsObserver = Observer<List<Item>> {

            for (fruta in it) {
                Log.d("Item:", fruta.nombre)
            }

            for ((index, value) in it.withIndex()) {
                Log.d("Item $index:", value.nombre)
            }
        }
        viewModel.getItemsLiveData().observe(this.requireActivity(), itemsObserver)
    }

}