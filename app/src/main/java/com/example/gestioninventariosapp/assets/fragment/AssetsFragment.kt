package com.example.gestioninventariosapp.assets.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.assets.items.AssetsItem
import com.example.gestioninventariosapp.assets.viewmodel.AssetsViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_assets.*
import javax.inject.Inject

class AssetsFragment : DaggerFragment() {

    @Inject lateinit var testString: String
    @Inject lateinit var viewModel: AssetsViewModel

    val assetsAdapter= GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_assets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAssets.layoutManager=LinearLayoutManager(context,VERTICAL,false)
        recyclerAssets.adapter=assetsAdapter

        text_view_frag_asset.setOnClickListener{viewModel.createAsset(
            new_asset_name.text.toString(),
            new_asset_desc.text.toString(),
            "Y8gpt9xLkvty7agvsgiz",
            new_asset_cantidad.text.toString().toInt(),
            new_asset_type.text.toString()
        )}

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getAssetLiveData().observe(viewLifecycleOwner, Observer { assets->
            assetsAdapter.addAll(
                assets.map{AssetsItem(it)}
            )
        })
        viewModel.getOncreatedAssetData().observe(viewLifecycleOwner, Observer { boolean->
            if(boolean){
             Log.i("creador","se creo")
            }else{
                Log.e("creador"," no se creo")
            }

        })

    }




}