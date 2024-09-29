package com.example.projectkotlin2.activity

import ManagmentCart
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.projectkotlin2.R
import com.example.projectkotlin2.adapter.PicAdapter
import com.example.projectkotlin2.adapter.SelectModelApdater
import com.example.projectkotlin2.databinding.ActivityDetailBinding
import com.example.projectkotlin2.model.ItemsModel
import java.util.ResourceBundle.getBundle

class DetailActivity : BaseActivity() {
    private  lateinit var item:ItemsModel
    private  lateinit var managmentCart: ManagmentCart
    private lateinit var binding:ActivityDetailBinding;
    private var numberOrder=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart=ManagmentCart(this);

        getBundle()
        initList()

    }

    private fun initList() {
        val modelList=ArrayList<String>();
        for (   model in item.model)
        {
            modelList.add(model)
        }
        binding.modelList.adapter=SelectModelApdater(modelList)
        binding.modelList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val picList=ArrayList<String>();
        for (   model in item.picUrl)
        {
            picList.add(model)
        }
        Glide.with(this)
            .load(picList[0])
            .into(binding.img)

        binding.picList.adapter=PicAdapter(picList){
            imgUrl->Glide.with(this).load(imgUrl).into(binding.img)
        }
        binding.picList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }


    private fun getBundle() {
        item=intent.getParcelableExtra("object")!!
        binding.titleTxt.text=item.title
        binding.descriptionTxt.text=item.description
        binding.priceTxt.text="$"+item.price
        binding.ratingTxt.text="${item.rating} Rating"
        binding.addToCartBtn.setOnClickListener{
            item.numberInCart=numberOrder
            managmentCart.insertItem(item)
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
        binding.cartBtn.setOnClickListener{
          //  startActivity(Intent(this@DetailActivity,))
        }

    }
}