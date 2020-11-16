package com.example.gestioninventariosapp.documents.fragment

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations.map
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gestioninventariosapp.R
import com.example.gestioninventariosapp.assets.fragment.AssetsFragment
import com.example.gestioninventariosapp.assets.items.AssetsItem
import com.example.gestioninventariosapp.documents.items.DocumentsItem
import com.example.gestioninventariosapp.documents.viewmodel.DocumentViewModel
import com.example.gestioninventariosapp.ui.prefs.MyPreference
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_assets.*
import kotlinx.android.synthetic.main.fragment_assets.recyclerAssets
import kotlinx.android.synthetic.main.fragment_documents.*
import kotlinx.android.synthetic.main.list_item_document.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DocumentsFragment : DaggerFragment() {
    @Inject
    lateinit var viewModel: DocumentViewModel
    val documentsAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_documents, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userId = arguments?.getString("idUser")

        if (userId!=null){
            val cantidad= arguments?.getInt("cantidad")
            val name = arguments?.getString("name")
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            viewModel.createDocument(name,cantidad,userId,currentDate,"Edit client name!")
            viewModel.getOncreatedDocumentData().observe(viewLifecycleOwner, Observer {boolean->
                if (boolean){
                    Log.e("doc valido","se creo")
                    recyclerDocuments.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    recyclerDocuments.adapter = documentsAdapter
                    val myPreference= MyPreference(requireContext())
                    viewModel.verData(
                        myPreference.getUserId()?:""
                    )
                    viewModel.getDocumentLiveData().observe(viewLifecycleOwner, Observer { document ->
                        documentsAdapter.addAll(
                            document.map { DocumentsItem(it) }
                        )

                    })
                    Toast.makeText(getContext(),"Your inventory was delivery succesfull",Toast.LENGTH_LONG)

                }else{
                    Log.i("doc invalido","no se creo")



                }
            })
        }else{
            recyclerDocuments.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            recyclerDocuments.adapter = documentsAdapter
            val myPreference= MyPreference(requireContext())
            viewModel.verData(
                myPreference.getUserId()?:""
            )
        }



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userId = arguments?.getString("idUser")
        if(userId==null){
            viewModel.getDocumentLiveData().observe(viewLifecycleOwner, Observer { document ->
                documentsAdapter.addAll(
                    document.map { DocumentsItem(it) }
                )

            })
        }



    }
    companion object {
        @JvmStatic
        fun newInstance(): DocumentsFragment {
            val fragment = DocumentsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}