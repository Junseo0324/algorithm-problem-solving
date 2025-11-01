package BOJ.implementation

// https://www.acmicpc.net/problem/2167

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val array = Array(n) {IntArray(m)}
    repeat(n) {
        array[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    val k = readln().toInt()
    repeat(k) {
        val (i,j,x,y) = readln().split(" ").map { it.toInt() }
        var answer = 0
        for (l in i-1 until x) {
            for (o in j-1 until y) {
                answer += array[l][o]
            }
        }
        println(answer)
    }
}