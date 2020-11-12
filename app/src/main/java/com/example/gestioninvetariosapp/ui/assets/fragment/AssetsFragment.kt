package com.example.gestioninvetariosapp.ui.assets.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
<<<<<<< Updated upstream:app/src/main/java/com/example/gestioninvetariosapp/ui/assets/fragment/AssetsFragment.kt
import com.example.gestioninvetariosapp.ui.assets.AssetViewModel
import com.example.gestioninvetariosapp.ui.assets.adapter.items.AssetsItems
=======
import com.example.gestioninventariosapp.R
import kotlinx.android.synthetic.main.fragment_assets.*
import com.example.gestioninventariosapp.assets.viewmodel.AssetViewModel
import com.example.gestioninventariosapp.assets.item.AssetsItems
>>>>>>> Stashed changes:app/src/main/java/com/example/gestioninventariosapp/assets/fragment/AssetsFragment.kt
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

<<<<<<< Updated upstream:app/src/main/java/com/example/gestioninvetariosapp/ui/assets/fragment/AssetsFragment.kt
class AssetsFragment : Fragment() {

    val assetsAdapter= GroupAdapter<GroupieViewHolder>()
    val viewModel: AssetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
=======
class AssetsFragment : DaggerFragment() {
    @Inject lateinit var testString: String
    @Inject lateinit var viewModel: AssetViewModel
    //@Inject lateinit var testString: String

    val assetsAdapter= GroupAdapter<GroupieViewHolder>()
>>>>>>> Stashed changes:app/src/main/java/com/example/gestioninventariosapp/assets/fragment/AssetsFragment.kt

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_assets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< Updated upstream:app/src/main/java/com/example/gestioninvetariosapp/ui/assets/fragment/AssetsFragment.kt
=======
        text_view_frag_asset.text=testString
>>>>>>> Stashed changes:app/src/main/java/com/example/gestioninventariosapp/assets/fragment/AssetsFragment.kt
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
<<<<<<< Updated upstream:app/src/main/java/com/example/gestioninvetariosapp/ui/assets/fragment/AssetsFragment.kt
=======

>>>>>>> Stashed changes:app/src/main/java/com/example/gestioninventariosapp/assets/fragment/AssetsFragment.kt


}