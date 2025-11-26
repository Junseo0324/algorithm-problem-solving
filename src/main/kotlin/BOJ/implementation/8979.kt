package BOJ.implementation

// https://www.acmicpc.net/problem/8979
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = Array(n + 1) { IntArray(n) }
    val answer = IntArray(n+1)
    repeat(n) {
        array[it + 1] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    for (j in 0..<n) { // 금,은,동 확인?
        for (i in 1..n) {

        }
    }
}