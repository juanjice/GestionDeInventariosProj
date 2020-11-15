package com.example.gestioninventariosapp.assets.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.assets.items.AssetsItem
import com.example.gestioninventariosapp.assets.viewmodel.AssetsViewModel
import com.example.gestioninventariosapp.ui.fragments.HomeFragment
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
        var userId = arguments?.getString("userId")
        viewModel.verData(
            userId?:""
        )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getAssetLiveData().observe(viewLifecycleOwner, Observer { assets->
            assetsAdapter.addAll(
                assets.map{AssetsItem(it)}
            )

        })

    }
    companion object {
        @JvmStatic
        fun newInstance(): AssetsFragment {
            val fragment = AssetsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }



}