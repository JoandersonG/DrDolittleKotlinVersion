package com.example.drdolittle.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.drdolittle.R
import com.example.drdolittle.databinding.AnimalDetailsFragmentBinding
import com.example.drdolittle.ui.main.viewmodel.AnimalDetailsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.animal_details_fragment.*

class AnimalDetailsFragment : Fragment() {

    private val args: AnimalDetailsFragmentArgs by navArgs()
    private val viewModel:  AnimalDetailsViewModel by viewModels {
        AnimalDetailsViewModel.Factory(args.category)
    }
    private lateinit var binding : AnimalDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.animal_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = AnimalDetailsFragmentBinding.bind(view)
        viewModel.animals.observe(viewLifecycleOwner, {
            if (!viewModel.resultReady()) {
                return@observe
            }
            binding.animal = viewModel.getNextAnimal()
            vfAnimalDetails.displayedChild = 1
        })

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