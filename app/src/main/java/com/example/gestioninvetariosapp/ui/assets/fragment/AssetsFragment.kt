package com.example.gestioninvetariosapp.ui.assets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homecenterapp.R
import kotlinx.android.synthetic.main.fragment_assets.*
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.gestioninvetariosapp.ui.assets.AssetViewModel
import com.example.gestioninvetariosapp.ui.assets.adapter.items.AssetsItems
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class AssetsFragment : Fragment() {

    val assetsAdapter= GroupAdapter<GroupieViewHolder>()
    val viewModel: AssetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_assets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAssets.layoutManager=LinearLayoutManager(context,VERTICAL,false)
        recyclerAssets.adapter=assetsAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getArticleLiveData().observe(viewLifecycleOwner,{itemaset->
            assetsAdapter.addAll(
                itemaset.map{AssetsItems(it)})
        }

        )
    }


}