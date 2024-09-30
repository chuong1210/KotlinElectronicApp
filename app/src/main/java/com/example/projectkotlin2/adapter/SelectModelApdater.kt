package com.example.projectkotlin2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectkotlin2.R
import com.example.projectkotlin2.databinding.ViewholderModelBinding

class SelectModelApdater(val item:MutableList<String>):RecyclerView.Adapter<SelectModelApdater.Viewholder>() {

    private var selectedPosition=-1
    private var lastSelectedPostion=-1
    private lateinit var context: Context
   inner class Viewholder(val binding:ViewholderModelBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectModelApdater.Viewholder {
        context=parent.context
        val binding=ViewholderModelBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: SelectModelApdater.Viewholder, position: Int) {
holder.binding.modelTxt.text=item[position]
        holder.binding.root.setOnClickListener{
            lastSelectedPostion=selectedPosition
            selectedPosition=position
            notifyItemChanged(selectedPosition)
            notifyItemChanged(lastSelectedPostion)
        }

        if(selectedPosition==position)
        {
holder.binding.modelLayout.setBackgroundResource(R.drawable.green_bg_selected)
            holder.binding.modelTxt.setTextColor(context.resources.getColor(R.color.green))

        }
else
        {
            holder.binding.modelLayout.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.modelTxt.setTextColor(context.resources.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int=item.size
}