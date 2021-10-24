package com.example.drdolittle.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


object DatabaseManager {

    private val database = Firebase.database
    private val animalReference = database.getReference("animals")
    private var animalListener : ValueEventListener? =  null

    private val _allAnimals = MutableLiveData<List<Animal>>()
    var allAnimals : LiveData<List<Animal>>
         get() = _allAnimals
         set(newList) { _allAnimals.value = newList.value}

    fun getAnimalsByCategory(category: Category) {
        animalListener?.let { animalReference.removeEventListener(it) }
        _allAnimals.value = listOf()
        animalListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val animals = mutableListOf<Animal>()
                for (ds in snapshot.children) {
                    ds.getValue(Animal::class.java)?.let { animals.add(it) }
                }
                _allAnimals.value = animals
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("DatabaseManager", "loadPost:onCancelled", error.toException())
            }

        }
        animalReference.orderByChild("categories/" + category.name)
                        .equalTo(true)
                        .addListenerForSingleValueEvent(animalListener as ValueEventListener)
    }

    fun getAllAnimals() {
        animalListener?.let { animalReference.removeEventListener(it) }
        _allAnimals.value = listOf()
        animalListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //Recupero todos os animais
                val animals = mutableListOf<Animal>()
                for (ds in snapshot.children) {
                    ds.getValue(Animal::class.java)?.let { animals.add(it) }
                }
                _allAnimals.value = animals
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("DatabaseManager", "loadPost:onCancelled", error.toException())
            }

        }
        animalReference.addListenerForSingleValueEvent(animalListener as ValueEventListener)
    }
}