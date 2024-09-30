package com.example.projectkotlin2.adapter

import ManagmentCart
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1762.Helper.ChangeNumberItemsListener
import com.example.projectkotlin2.databinding.ViewHolderCategoryBinding
import com.example.projectkotlin2.databinding.ViewholderCartBinding
import com.example.projectkotlin2.model.ItemsModel

class CartAdapter(private val listitemSelected: ArrayList<ItemsModel>,context:Context,var changeNumberItemsListener: ChangeNumberItemsListener):RecyclerView.Adapter<CartAdapter.Viewholder>() {
    class Viewholder (val binding: ViewholderCartBinding):RecyclerView.ViewHolder(binding.root)

    private  val managmentCart=  ManagmentCart(context);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.Viewholder {
        val binding=ViewholderCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.Viewholder, position: Int) {
        val item= listitemSelected[position]
        holder.binding.titleTxt.text=item.title
        holder.binding.feeEachTimeTxt.text="$${item.price}"
        holder.binding.totalEachItemTxt.text="$${Math.round(item.numberInCart*item.price)}"
        holder.binding.numberItemTxt.text="${item.numberInCart.toString()}"

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .into(holder.binding.pic)
        holder.binding.plusCartBtn.setOnClickListener{
            managmentCart.plusItem(listitemSelected,position,object  :ChangeNumberItemsListener{
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener.onChanged()
                }

            })
        }

        holder.binding.miniusCartBtn.setOnClickListener{
            managmentCart.minusItem(listitemSelected,position,object  :ChangeNumberItemsListener{
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener.onChanged()
                }

            })
        }
    }

    override fun getItemCount(): Int = listitemSelected.size
}