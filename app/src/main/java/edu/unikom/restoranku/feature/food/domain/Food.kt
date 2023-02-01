package edu.unikom.restoranku.feature.food.domain

data class Food(
    val code: String,
    val name: String,
    val image: Int,
    val category: FoodTypes,
    val desc: String,
    val price: Int,
)
