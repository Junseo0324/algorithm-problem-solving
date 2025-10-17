package BOJ.hash

// https://www.acmicpc.net/problem/7785

fun main() {
    val n = readln().toInt()
    val hashMap = mutableMapOf<String, String>()
    repeat(n) {
        val (name, status) = readln().split(" ")
        hashMap[name] = status
    }
    println(
        hashMap.filter {
            it.value == "enter"
        }.map { it.key }.sortedDescending().joinToString("\n")
    )
}