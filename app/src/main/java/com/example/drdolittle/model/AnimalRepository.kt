package com.example.drdolittle.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AnimalRepository {

    private var animalFakeList = MutableLiveData<List<Animal>>()

    init {
        animalFakeList.value = listOf(
            Animal(
            "Animal exemplo 1",
            "Animauls Latinum",
        "Este é um detalhe extra arespeito desse animal exemplo",
        "Ele é encontrado em vegetações de determinado tipo",
            "Plantas, insetos, pequenos animais, por exemplo"
        ),
            Animal(
                "Animal exemplo 2",
                "Segundo Animauls Latinum",
                "Este é um detalhe extra a respeito desse animal exemplo 2",
                "Ele é encontrado em vegetações de determinado outro tipo",
                "Plantas, insetos, pequenos animais, ou nenhum desses?"
            )
        )
    }

    fun getAnimals() : LiveData<List<Animal>>{
        return animalFakeList
    }
}