package edu.unikom.restoranku.feature.food.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import edu.unikom.restoranku.R
import edu.unikom.restoranku.databinding.FragmentFoodMenuBinding
import edu.unikom.restoranku.feature.food.domain.Food
import edu.unikom.restoranku.feature.food.domain.FoodTypes
import edu.unikom.restoranku.module.ViewBindingFragment

class FoodMenuViewBindingFragment : ViewBindingFragment<FragmentFoodMenuBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentFoodMenuBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtonEvent()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val foodAdapter = FoodRecyclerViewAdapter(generateDefaultFoodData())
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerViewFood.adapter = foodAdapter
        binding.recyclerViewFood.layoutManager = layoutManager
    }

    private fun initButtonEvent() =
        binding.btnFloatOrder.setOnClickListener {
            findNavController().navigate(R.id.action_foodMenuViewBindingFragment_to_orderFormViewBindingFragment)
        }

    private fun generateDefaultFoodData(): List<Food> =
        listOf(
            Food(
                "B01",
                "Kopi Hitam",
                R.drawable.img_black_coffee,
                FoodTypes.Minuman,
                "Kopi Hitam dibuat dengan teknik espresso, dimana biji kopi yang digunakan berasal dari Aceh Gayo jenis Arabika, disajikan dengan gula terpisah",
                10000
            ),
            Food(
                "B02",
                "Cappuccino",
                R.drawable.img_cappuccino,
                FoodTypes.Minuman,
                "Paduan kopi dengan buih susu kental serta menggunakan sirup karamel, dimana biji kopi yang digunakan berasal dari Gunung Puntang Jawa Barat jenis Robusta",
                20000
            ),
            Food(
                "B03",
                "Sparkling Tea",
                R.drawable.img_sparkling_tea,
                FoodTypes.Minuman,
                "Minuman Teh yang menggunakan daun teh dari pegunungan daerah Garut dengan tambahan sari melati asli dan gula merah alami",
                15000
            ),
            Food(
                "F01",
                "Batagor",
                R.drawable.img_cappuccino,
                FoodTypes.Makanan,
                "Baso dan Tahu Goreng dengan sajian bumbu kacang dan kecap khas Bandung",
                25000
            ),
            Food(
                "F02",
                "Cireng",
                R.drawable.img_cappuccino,
                FoodTypes.Makanan,
                "Makanan ringan berupa tepung kanji goreng dengan bahan dasar tempe fermentasi yang disebut oncom, disajikan dengan bumbu kacang pedas",
                10000
            ),
            Food(
                "F03",
                "Nasi Goreng",
                R.drawable.img_fried_rice,
                FoodTypes.Makanan,
                "Nasi goreng ayam yang disajikan dengan telur mata sapi disertai satai ayam",
                50000
            ),
            Food(
                "D01",
                "Cheese Cake",
                R.drawable.img_cheese_cake,
                FoodTypes.Dessert,
                "Kue Tart 1 slice dengan bahan utama cream cheese dengan topping buah-buahan asli seperti anggur, jeruk, kiwi",
                40000
            ),
            Food(
                "D02",
                "Black Salad",
                R.drawable.img_black_salad,
                FoodTypes.Dessert,
                "Potongan buah-buah segar yang terdiri dari Pepaya, Jambu, Melon, dan Mangga disajikan dengan bumbu rujak kacang pedas dan gula merah",
                30000
            ),
        )
}