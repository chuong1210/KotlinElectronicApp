package com.example.projectkotlin2.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.projectkotlin2.R
import com.example.projectkotlin2.adapter.CategoryAdapter
import com.example.projectkotlin2.adapter.RecommendedAdapter
import com.example.projectkotlin2.adapter.SliderAdapter
import com.example.projectkotlin2.databinding.ActivityHomeBinding
import com.example.projectkotlin2.model.SliderModel
import com.example.projectkotlin2.viewmodel.MainViewModel

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel=MainViewModel();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanners();
        initCategories()
        initRecommened()


    }

    private fun initRecommened() {
        binding.progressBarRecommendation.visibility=View.GONE;
        viewModel.recommended.observe(this,Observer{
            binding.ViewRecommendation.layoutManager=GridLayoutManager(this@HomeActivity,2)
            binding.ViewRecommendation.adapter=RecommendedAdapter(it)
            binding.progressBarSlider.visibility=View.VISIBLE
        })
        viewModel.loadRecommended()
    }

    private fun initCategories() {
        binding.progressBarCategory.visibility=View.VISIBLE;
        viewModel.categories.observe(this,Observer{
            binding.ViewCategory.layoutManager=LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.ViewCategory.adapter=CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE;


        })
        viewModel.loadCategories()
    }

    private fun banners(image:List<SliderModel>)
    {
    binding.viewPager2.adapter=SliderAdapter(image,binding.viewPager2);
        binding.viewPager2.clipToPadding=false;
        binding.viewPager2.clipChildren=false;
        binding.viewPager2.offscreenPageLimit=1
        binding.viewPager2.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER;

        val compositePageTransformer=CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40)) }
        binding.viewPager2.setPageTransformer(compositePageTransformer);

if(image.size>1)
{
    binding.dotIndicator.visibility= View.VISIBLE;
    binding.dotIndicator.attachTo(binding.viewPager2);
}

    }

    private fun initBanners()
    {
        binding.progressBarSlider.visibility=View.VISIBLE;
        viewModel.banner.observe(this, Observer {
            banners(it);
            binding.progressBarSlider.visibility=View.GONE;
        })
        viewModel.loadBanners()
    }

}