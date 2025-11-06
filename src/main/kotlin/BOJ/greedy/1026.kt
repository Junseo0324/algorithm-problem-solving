package BOJ.greedy

// https://www.acmicpc.net/problem/1026

fun main() {
    readln().toInt()
    var a = readln().split(" ").map { it.toInt() }.toList()
    var b = readln().split(" ").map { it.toInt() }.toList()

    a = a.sorted()
    b = b.sortedDescending()

    var answer = 0
    for (i in a.indices) {
        answer += a[i] * b[i]
    }
    println(answer)
}