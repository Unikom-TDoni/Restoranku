package edu.unikom.restoranku.feature.food.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.unikom.restoranku.databinding.ItemFoodListBinding
import edu.unikom.restoranku.feature.food.domain.Food
import java.text.DecimalFormat

class FoodRecyclerViewAdapter(
    private val data: List<Food>
) :
    RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFoodListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemFoodListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int =
        data.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        val currentData = data[position]

        binding.txtViewName.text = currentData.name
        binding.txtViewDesc.text = currentData.desc
        Glide.with(binding.imgViewMenu).load(currentData.image).into(binding.imgViewMenu)
        binding.txtViewPrice.text = "Rp.${DecimalFormat("#,###.##").format(currentData.price)}"
        binding.txtViewCategory.text = currentData.category.toString()
    }
}