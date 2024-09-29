package com.example.projectkotlin2.adapter

import android.content.Context
import android.content.Intent
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
import com.example.projectkotlin2.activity.DetailActivity
import com.example.projectkotlin2.databinding.SliderItemContainerBinding
import com.example.projectkotlin2.databinding.ViewHolderCategoryBinding
import com.example.projectkotlin2.databinding.ViewHolderRecommendedBinding
import com.example.projectkotlin2.model.CatagoryModel
import com.example.projectkotlin2.model.ItemsModel
import com.example.projectkotlin2.model.SliderModel

class RecommendedAdapter(private var items:MutableList<ItemsModel>):RecyclerView.Adapter<RecommendedAdapter.ViewHolder>() {
    private lateinit var  context: Context
    private var selectedPosition=-1
    private var lastSelectedPostion=-1


   inner class ViewHolder(val binding: ViewHolderRecommendedBinding):RecyclerView.ViewHolder(binding.root) {
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
    ): RecommendedAdapter.ViewHolder {
        val binding=ViewHolderRecommendedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecommendedAdapter.ViewHolder, position: Int) {
        val item=items[position]
        with(holder.binding)
        {
            titleTxt.text=item.title
            priceTxt.text="$${item.price}"
            ratingTxt.text=item.rating.toString();
            Glide.with(holder.itemView.context)
                .load(item.picUrl[0])
                .into(holder.binding.pic)

            root.setOnClickListener{
            val intent=Intent(holder.itemView.context,DetailActivity::class.java).apply {
                 putExtra("object",item)
            }
                ContextCompat.startActivity(holder.itemView.context,intent,null)
            }
        }


    }

    override fun getItemCount(): Int=items.size
}