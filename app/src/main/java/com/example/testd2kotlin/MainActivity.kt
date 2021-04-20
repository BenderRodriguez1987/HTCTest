package com.example.testd2kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private lateinit var context: Context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        val viewModel = MainViewModel(context)
        val recycler = findViewById<RecyclerView>(R.id.employees_rv)
        recycler.adapter = viewModel.adapter
        viewModel.loadData()
    }
}
