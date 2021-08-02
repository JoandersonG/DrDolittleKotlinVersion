package com.example.drdolittle.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.drdolittle.model.Animal
import com.example.drdolittle.model.AnimalRepository

class AnimalDetailsViewModel : ViewModel() {

    private val repository : AnimalRepository = AnimalRepository()

    private val animals : LiveData<List<Animal>> = repository.getAnimals()

    private var index = -1

    fun getNextAnimal(): Animal? {
        animals.value?.let {
            if (index+1 < it.size) {
                return animals.value?.get(++index)
            }
        }
        return null
    }

    fun hasNextAnimal(): Boolean {
        animals.value?.let {
            return index+1 < it.size
        }
        return false
    }

    fun getPreviousAnimal(): Animal? {
        if (index-1 >= 0) {
            return animals.value?.get(--index)
        }
        return null
    }

    fun hasPreviousAnimal(): Boolean {
        return index-1 >= 0
    }
}