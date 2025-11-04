package BOJ.greedy

import kotlin.math.min

fun main() {
    val n = readln()
    val array = n.map { it.digitToInt() }
    val answer = mutableListOf<Int>()

    for (i in array.indices) {
        if (answer.isNotEmpty()) {
            if (answer.last() != array[i]) {
                answer.add(array[i])
            }
        } else {
            answer.add(array[i])
        }
    }
    println(min(answer.count { it == 0 }, answer.count { it == 1 }))
}