package BOJ.greedy

// https://www.acmicpc.net/problem/11047

/**
 * 큰 것부터 나누면 된다.
 */

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var money = k
    var answer = 0
    var array = mutableListOf<Int>()

    repeat(n) {
        array.add(readln().toInt())
    }

    array = array.sortedDescending().toMutableList()

    array.forEach {
        if (it <= money) {
            val count = money / it
            money -= (count * it)
            answer += count
        }
    }

    println(answer)
}