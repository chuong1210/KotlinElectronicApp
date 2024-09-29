package com.example.projectkotlin2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectkotlin2.R
import com.example.projectkotlin2.databinding.ViewholderPicBinding

class PicAdapter(val item:MutableList<String>,private val onImageSelected:(String)->Unit):RecyclerView.Adapter<PicAdapter.ViewHolder>() {
   private var selectedPosition=-1
    private var lastSelectedPostion=-1
  inner  class ViewHolder(val binding:ViewholderPicBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicAdapter.ViewHolder {
        val binding=ViewholderPicBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicAdapter.ViewHolder, position: Int) {
        val item=item[position]
        holder.binding.pic.loadImage(item)
        holder.binding.root.setOnClickListener{
            lastSelectedPostion=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPostion)
            notifyItemChanged(selectedPosition)

            onImageSelected(item)


        }

        if(selectedPosition==position)
        {
            holder.binding.picLayout.setBackgroundResource(R.drawable.gree_bg_selected)

        }
else
        {
            holder.binding.picLayout.setBackgroundResource(R.drawable.grey_bg)

        }
    }

    override fun getItemCount(): Int = item.size
    fun ImageView.loadImage(url:String)
    {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }

}