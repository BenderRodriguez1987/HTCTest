package com.example.testd2kotlin

import android.content.Context
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(context: Context) : ViewModel() {

    val adapter = RecyclerAdapter(context)

    fun loadData() {
        getCompany()
    }

    private fun getCompany() = retrofit.create(MockyService::class.java)
        .getCompany()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { rootObject ->
            adapter.setEmployees(rootObject.company.employees)
            adapter.notifyDataSetChanged()
        }
}