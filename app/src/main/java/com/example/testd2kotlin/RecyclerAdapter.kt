package com.example.testd2kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_employee.view.*

class RecyclerAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var employees: List<Employee>

    fun setEmployees(employees: List<Employee>) {
        this.employees = employees
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(context)
            .inflate(R.layout.item_employee, parent, false)
            .let { ViewHolder(it, employees) }

    override fun getItemCount() = employees.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                employees.get(position).toString(),
                Toast.LENGTH_LONG
            )
        }
    }

    class ViewHolder(itemView: View, employees: List<Employee>) :
        RecyclerView.ViewHolder(itemView) {

        private val employees: List<Employee>

        init {
            this.employees = employees
        }

        fun bind() {
            employees.get(adapterPosition).let {  employee ->
                employee.name?.let { itemView.name.setText(it) }
                employee.phone_number?.let { itemView.phone_number.setText(it) }
                employee.skills?.let { itemView.skills.setText(it.toString()) }
            }
        }
    }
}