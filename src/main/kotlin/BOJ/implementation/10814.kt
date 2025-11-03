package BOJ.implementation

// https://www.acmicpc.net/problem/10814

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, String>>()
    repeat(n) {
        val (age, name) = readln().split(" ")
        list.add(age.toInt() to name)
    }

    val sortedList = list.sortedBy { it.first }

    sortedList.forEach {
        val (age, name) = it
        println("$age $name")
    }
}