package com.example.drdolittle.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.drdolittle.R
import com.example.drdolittle.databinding.AnimalDetailsFragmentBinding
import com.example.drdolittle.ui.main.viewmodel.AnimalDetailsViewModel
import com.google.android.material.snackbar.Snackbar

class AnimalDetailsFragment : Fragment() {

    private lateinit var viewModel: AnimalDetailsViewModel
    private lateinit var binding : AnimalDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.animal_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalDetailsViewModel::class.java)

        binding = AnimalDetailsFragmentBinding.bind(view)
        binding.animal = viewModel.getNextAnimal()

        binding.btNext.setOnClickListener {
            if (viewModel.hasNextAnimal()) {
                binding.animal = viewModel.getNextAnimal()
            } else {
                Snackbar.make(view, "Você já viu todos os animais disponíveis! Espere chegar mais.", Snackbar.LENGTH_LONG).show()
            }
        }

        binding.btPrevious.setOnClickListener {
            if (viewModel.hasPreviousAnimal()) {
                binding.animal = viewModel.getPreviousAnimal()
            } else {
                Snackbar.make(view, "Este é o primeiro animal que você viu.", Snackbar.LENGTH_LONG).show()
            }
        }
    }

}