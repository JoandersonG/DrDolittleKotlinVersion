package com.example.drdolittle.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.drdolittle.R
import com.example.drdolittle.ui.main.viewmodel.AnimalDetailsViewModel
import com.example.drdolittle.ui.main.viewmodel.MainViewModel

class AnimalDetailsFragment : Fragment() {

    private lateinit var viewModel: AnimalDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.animal_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalDetailsViewModel::class.java)
    }

}