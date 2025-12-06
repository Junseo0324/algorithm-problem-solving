package BOJ.implementation

// https://www.acmicpc.net/problem/23971

fun main() {
    val (h, w, n, m) = readln().split(" ").map { it.toInt() }

    val height = (h+n) / (n+1)

    val width = (w+m) / (m+1)

    val total = height * width

    println(total)

}