package com.example.projectkotlin2.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.projectkotlin2.databinding.SliderItemContainerBinding
import com.example.projectkotlin2.databinding.ViewHolderCategoryBinding
import com.example.projectkotlin2.model.CatagoryModel
import com.example.projectkotlin2.model.SliderModel

class CategoryAdapter(private var items:MutableList<CatagoryModel>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private lateinit var  context: Context
    private var selectedPosition=-1
    private var lastSelectedPostion=-1


   inner class ViewHolder(val binding: ViewHolderCategoryBinding):RecyclerView.ViewHolder(binding.root) {
init {
    binding.root.setOnClickListener{
        val position=adapterPosition
        if(position!=RecyclerView.NO_POSITION){
            lastSelectedPostion=selectedPosition;
            selectedPosition=position
            notifyItemChanged(lastSelectedPostion)
            notifyItemChanged(selectedPosition)

        }
    }
}
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.ViewHolder {
        val binding=ViewHolderCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.titleTxt.text=item.title
       Glide.with(holder.itemView.context)
           .load(item.picUrl)
           .into(holder.binding.pic)

        if(selectedPosition==position) {
            holder.binding.pic.setBackgroundResource(0)
            holder.binding.mainLayout.setBackgroundResource(com.example.projectkotlin2.R.drawable.green_button_bg)
            ImageViewCompat.setImageTintList(holder.binding.pic,
                ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.context,com.example.projectkotlin2.R.color.white))

            )
            holder.binding.titleTxt.visibility= View.VISIBLE
            holder.binding.titleTxt.setTextColor(ContextCompat.
            getColor(holder.itemView.context,com.example.projectkotlin2.R.color.white)
            )
        }

        else
        {
            holder.binding.pic.setBackgroundResource(com.example.projectkotlin2.R.drawable.green_button_bg)
            holder.binding.mainLayout.setBackgroundResource(0)
            ImageViewCompat.setImageTintList(holder.binding.pic,
                ColorStateList.valueOf(ContextCompat.getColor(holder.itemView.context,com.example.projectkotlin2.R.color.black))

            )
            holder.binding.titleTxt.visibility= View.GONE
            holder.binding.titleTxt.setTextColor(ContextCompat.
            getColor(holder.itemView.context,com.example.projectkotlin2.R.color.black)
            )
        }
    }

    override fun getItemCount(): Int=items.size
}