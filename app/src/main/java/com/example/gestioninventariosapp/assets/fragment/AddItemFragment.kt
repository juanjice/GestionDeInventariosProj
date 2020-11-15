package com.example.gestioninventariosapp.assets.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.assets.viewmodel.AssetsViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add_item.*
import javax.inject.Inject


class AddItemFragment : DaggerFragment() {
    @Inject
    lateinit var viewModel: AssetsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_item_button.setOnClickListener {
            viewModel.createAsset(
                new_asset_name.text.toString(),
                new_asset_desc.text.toString(),
                "Y8gpt9xLkvty7agvsgiz",
                new_asset_cantidad.text.toString().toInt(),
                new_asset_type.text.toString())
            findNavController().navigate(R.id.action_addItem_to_assets)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getOncreatedAssetData().observe(viewLifecycleOwner, Observer { boolean->
            if(boolean){
                Log.i("creador","se creo")
            }else{
                Log.e("creador"," no se creo")
            }

        })

    }


}