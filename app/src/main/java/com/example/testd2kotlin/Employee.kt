package com.example.testd2kotlin

class Employee(
    val name: String,
    val phone_number: String,
    val skills: List<String>
) : Comparable<Employee> {

    override fun compareTo(other: Employee) =
        if (name == other.name) 0
        else if (name.length > other.name.length) 1
        else -1
}