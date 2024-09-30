package com.example.projectkotlin2.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projectkotlin2.R
import com.example.projectkotlin2.adapter.ListitemAdapter
import com.example.projectkotlin2.databinding.ActivityDetailBinding
import com.example.projectkotlin2.databinding.ActivityListItemBinding
import com.example.projectkotlin2.viewmodel.MainViewModel
import java.util.ResourceBundle.getBundle

class ListItemActivity : BaseActivity() {
    private lateinit var  binding: ActivityListItemBinding
private val viewModel=MainViewModel();
    private var id:String = ""
    private var title:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
        initList()
    }

    private fun initList() {
        binding.apply {
            progressBarList.visibility=View.VISIBLE
            viewModel.recommended.observe(this@ListItemActivity,Observer{
                viewList.layoutManager=GridLayoutManager(this@ListItemActivity,2)
                viewList.adapter=ListitemAdapter(it)
                progressBarList.visibility=View.GONE
            })
            viewModel.loadFiltered(id);
        }
    }

    private fun getBundle() {
        id=intent.getStringExtra("id")!!
        title=intent.getStringExtra("title")!!

        binding.categoryTxt.text=title.toString();

    }
}