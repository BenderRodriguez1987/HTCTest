package com.example.testd2kotlin

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel() : ViewModel() {

    val employees = MutableLiveData<List<Employee>>()

    fun loadData() {
        getCompany()
    }

    private fun getCompany() = retrofit.create(MockyService::class.java)
        .getCompany()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { rootObject ->
            employees.postValue(rootObject.company.employees)
        }
}