package com.example.projectkotlin2.viewmodel

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectkotlin2.model.CatagoryModel
import com.example.projectkotlin2.model.ItemsModel
import com.example.projectkotlin2.model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainViewModel():ViewModel() {
    private  val firebaseDatabase: FirebaseDatabase=FirebaseDatabase.getInstance();
    private val _bannner=MutableLiveData<List<SliderModel>>();
    private val _category=MutableLiveData<MutableList<CatagoryModel>>();
    private val _recommneded=MutableLiveData<MutableList<ItemsModel>>()

    val banner:LiveData<List<SliderModel>>
        =
            _bannner
val categories:LiveData<MutableList<CatagoryModel>> = _category
    val recommended:LiveData<MutableList<ItemsModel>> = _recommneded

fun loadRecommended()
{
    val Ref=firebaseDatabase.getReference("Items")
    val query:Query=Ref.orderByChild("showRecommeded").equalTo(true)
    query.addListenerForSingleValueEvent(object :ValueEventListener
    {
        override fun onDataChange(snapshot: DataSnapshot) {

            val lists= mutableListOf<ItemsModel>()
            for (childsnapshot in snapshot.children)
            {
                val list=childsnapshot.getValue(ItemsModel::class.java)
                if(list!=null)
                {
                    lists.add(list);
                }

            }
            _recommneded.value=lists
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })



}

    fun loadRecommended()
    {
        val Ref=firebaseDatabase.getReference("Items")
        val query:Query=Ref.orderByChild("showRecommeded").equalTo(true)
        query.addListenerForSingleValueEvent(object :ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {

                val lists= mutableListOf<ItemsModel>()
                for (childsnapshot in snapshot.children)
                {
                    val list=childsnapshot.getValue(ItemsModel::class.java)
                    if(list!=null)
                    {
                        lists.add(list);
                    }

                }
                _recommneded.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })



    }

    fun loadCategories()
    {

        val Ref=firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object :ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<CatagoryModel>()
                for (childsnapshot in snapshot.children)
                {
                    val list=childsnapshot.getValue(CatagoryModel::class.java)
                    if(list!=null)
                    {
                        lists.add(list);
                    }

                }
                _category.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadBanners()
    {
        val Ref=firebaseDatabase.getReference("Banner")
        Ref.addValueEventListener(object :ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists= mutableListOf<SliderModel>()
                for (childsnapshot in snapshot.children)
                {
                    val list=childsnapshot.getValue(SliderModel::class.java)
                    if(list!=null)
                    {
                        lists.add(list);
                    }

                }
                _bannner.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}