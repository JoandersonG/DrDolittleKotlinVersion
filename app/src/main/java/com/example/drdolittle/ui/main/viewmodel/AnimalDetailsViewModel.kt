package com.example.drdolittle.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.drdolittle.model.Animal
import com.example.drdolittle.model.AnimalRepository
import com.example.drdolittle.model.Category

class AnimalDetailsViewModel constructor(
    category: Category?
) : ViewModel() {

    private val repository : AnimalRepository = AnimalRepository(if (category == Category.NENHUMA)  null else category)

    var animals : LiveData<List<Animal>> = repository.retrieveAnimals()

    init {
        getNextAnimal()
    }

    private var index = -1

    fun resultReady() : Boolean {
        return if (animals.value == null) false else (animals.value!!.isNotEmpty())
    }

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

    @Suppress("UNCHECKED_CAST")
    class Factory(private val category: Category?) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AnimalDetailsViewModel(category) as T
        }

    }
}