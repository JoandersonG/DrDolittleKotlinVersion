package com.example.drdolittle.model

import androidx.lifecycle.LiveData

class AnimalRepository(private val category : Category?) {

    fun retrieveAnimals() : LiveData<List<Animal>> {
        if (category == null) {
            DatabaseManager.getAllAnimals()
        } else {
            DatabaseManager.getAnimalsByCategory(category)
        }
        return DatabaseManager.allAnimals
    }

}