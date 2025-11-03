package BOJ.implementation

// https://www.acmicpc.net/problem/11651

fun main() {
    val array = mutableListOf<Pair<Int, Int>>()
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        array.add(x to y)
    }

    val sortedList = array.sortedWith(compareBy({ it.second }, { it.first }))

    sortedList.forEach {
        println("${it.first} ${it.second}")
    }
}