package BOJ.hash

// https://www.acmicpc.net/problem/10867
// sort?
fun main() {
    readln()
    val arr = readln().split(" ").map { it.toInt() }
    val result = arr.toSet().sorted()
    println(result.joinToString(" "))
}