package com.example.testd2kotlin

import android.content.Context
import androidx.lifecycle.ViewModel

class MainViewModel(context: Context) : ViewModel() {

    val adapter = RecyclerAdapter(context)

    fun loadData() {
        getCompany()
    }

    private fun getCompany() = retrofit.create(MockyService::class.java)
        .getCompany()
        .subscribe { rootObject ->
            adapter.setEmployees(rootObject.company.employees)
            adapter.notifyDataSetChanged()
        }
}