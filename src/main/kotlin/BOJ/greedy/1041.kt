package BOJ.greedy

import kotlin.math.min

/**
 * 3면 -> 4 M3
 * 2면 -> (4(n-2) + 4(n-1)) * M2
 * 1면 -> M1 * (4(n-2)(n-1) + (n-2)^2)
 * 주사위 마주보는 면 0-5, 1-4, 2-3
 */
fun main() {
    val n = readln().toLong()
    val array = readln().split(" ").map { it.toLong() }
    if (n == 1L) {
        println(array.sum() - array.max())
        return
    }
    val list = listOf(
        min(array[0], array[5]),
        min(array[1], array[4]),
        min(array[2], array[3]),
    ).sorted()

    val m1 = list[0]
    var m2 = list[0] + list[1]
    var m3 = list.sum()

    var answer = 0L
    answer += 4 * m3
    answer += (4 * (n - 2) + 4 * (n - 1)) * m2
    answer += (4 * (n - 2) * (n - 1) + (n - 2) * (n - 2)) * m1

    println(answer)
}