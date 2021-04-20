package com.example.testd2kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_employee.view.*

class RecyclerAdapter :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var employees: List<Employee>

    fun setEmployees(employees: List<Employee>) {
        this.employees = employees
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount() = employees.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(employees[position])
    }

    class ViewHolder(inflater: LayoutInflater,  parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_employee, parent, false)) {

        fun bind(employee: Employee) {
                employee.name?.let { itemView.name.setText(it) }
                employee.phone_number?.let { itemView.phone_number.setText(it) }
                employee.skills?.let { itemView.skills.setText(it.toString()) }
                itemView.setOnClickListener {
                Toast.makeText(
                    it.context,
                    employee.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}