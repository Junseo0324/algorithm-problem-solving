package BOJ.implementation

// https://www.acmicpc.net/problem/11650

fun main() {
    val n = readln().toInt()
    var array = mutableListOf<Pair<Int,Int>>()

    repeat(n) {
        val (x,y) = readln().split(" ").map { it.toInt() }
        array.add(x to y)
    }

    array = array.sortedWith(compareBy({it.first},{it.second})).toMutableList()


    array.forEach {
        println("${it.first} ${it.second}")
    }
}