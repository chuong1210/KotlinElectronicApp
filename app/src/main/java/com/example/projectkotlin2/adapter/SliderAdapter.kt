package com.example.projectkotlin2.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.projectkotlin2.databinding.SliderItemContainerBinding
import com.example.projectkotlin2.model.SliderModel

class SliderAdapter(private var sliderItems:List<SliderModel>,private val viewPager2: ViewPager2):RecyclerView.Adapter<SliderAdapter.SliderViewholder>() {
    private lateinit var  context: Context
    private val runnable= Runnable {
        sliderItems=sliderItems;
        notifyDataSetChanged()
    }
    class SliderViewholder(private val binding:SliderItemContainerBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderAdapter.SliderViewholder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}