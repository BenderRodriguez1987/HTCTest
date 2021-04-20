package com.example.testd2kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private lateinit var context: Context
    }
    private val adapter = RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        val viewModel = MainViewModel()
        val recycler = findViewById<RecyclerView>(R.id.employees_rv)
        viewModel.loadData()
        viewModel.employees.observe(this, Observer {
            adapter.setEmployees(it)
            recycler.layoutManager = LinearLayoutManager(context)
            recycler.adapter = adapter
        })
    }
}
