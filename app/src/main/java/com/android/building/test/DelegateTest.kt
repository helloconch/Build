package com.android.building.test

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()


    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean {
        return innerList.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerList.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerList.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return innerList.iterator()
    }
}

/**
 * 类代理
 */
class DelegatingCollection2<T>(innerList: Collection<T> = ArrayList<T>()) :
    Collection<T> by innerList {

}


class CountingSet<T>(
    val innnerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innnerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++;
        return innnerSet.add(element)
    }


    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size

        return innnerSet.addAll(elements)
    }

}

fun main() {
    val cSet = CountingSet<Int>()
    cSet.addAll(listOf(1, 1, 2))
    println("添加了${cSet.objectsAdded}个对象，集合中的元素个数：${cSet.size}")
}