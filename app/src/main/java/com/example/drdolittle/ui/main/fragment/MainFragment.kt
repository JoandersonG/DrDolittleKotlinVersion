package com.example.drdolittle.ui.main.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.drdolittle.R
import com.example.drdolittle.model.Category
import com.example.drdolittle.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setOnClicks()
    }

    private fun setOnClicks() {
        cvAnimalDoDia.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimalDetailsFragment(Category.NENHUMA)
            findNavController().navigate(action)
        }
        btAnimaisDomesticos.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimalDetailsFragment(Category.DOMESTICO)
            findNavController().navigate(action)
        }
        btAnimaisSelvagens.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimalDetailsFragment(Category.SELVAGEM)
            findNavController().navigate(action)
        }
        btAnimaisPerigosos.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimalDetailsFragment(Category.PERIGOSO)
            findNavController().navigate(action)
        }
        btAnimaisExtintos.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimalDetailsFragment(Category.EXTINTO)
            findNavController().navigate(action)
        }
    }

}