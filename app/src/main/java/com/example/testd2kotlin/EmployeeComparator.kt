package com.example.testd2kotlin

import java.lang.NullPointerException
import java.util.*
import java.util.function.Function
import java.util.function.ToDoubleFunction
import java.util.function.ToIntFunction
import java.util.function.ToLongFunction

class EmployeeComparator : Comparator<Employee?> {

    override fun compare(o1: Employee?, o2: Employee?): Int {
        if(o1 == null || o2 == null) {
            throw NullPointerException()
        }
        return o1.name.compareTo(o2.name)
    }

    override fun reversed(): Comparator<Employee?>? {
        return null
    }

    override fun thenComparing(other: Comparator<in Employee?>): Comparator<Employee?>? {
        return null
    }

    override fun <U> thenComparing(
        keyExtractor: Function<in Employee?, out U?>,
        keyComparator: Comparator<in U?>
    ): Comparator<Employee?>? {
        return null
    }

    override fun <U : Comparable<U?>?> thenComparing(keyExtractor: Function<in Employee?, out U?>): Comparator<Employee?>? {
        return null
    }

    override fun thenComparingInt(keyExtractor: ToIntFunction<in Employee?>): Comparator<Employee?>? {
        return null
    }

    override fun thenComparingLong(keyExtractor: ToLongFunction<in Employee?>): Comparator<Employee?>? {
        return null
    }

    override fun thenComparingDouble(keyExtractor: ToDoubleFunction<in Employee?>): Comparator<Employee?>? {
        return null
    }
}