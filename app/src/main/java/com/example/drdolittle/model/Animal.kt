package com.example.drdolittle.model

import com.google.firebase.database.Exclude

data class Animal(
    val name: String,
    val scientificName: String,
    val extraDetails: String,
    val whereToFind: String,
    val whatDoesItEat: String,
    @Exclude @JvmField
    val categories: List<Category>
)