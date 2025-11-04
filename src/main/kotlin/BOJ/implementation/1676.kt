package BOJ.implementation

// https://www.acmicpc.net/problem/1676

/**
 * 10!
 * 1
 * 2
 * 6
 */

fun main() {
    val n = readln().toInt()

    var count = 0
    var divisor = 5

    while (n / divisor >= 1) {
        count += (n / divisor)
        divisor *= 5
    }

    println(count)
}