package BOJ.hash

// https://www.acmicpc.net/problem/9375

fun main() {
    val case = readln().toInt()
    repeat(case) {
        val n = readln().toInt()
        val hashMap = mutableMapOf<String, Int>()
        var answer = 1
        repeat(n) {
            val (_, category) = readln().split(" ")
            hashMap[category] = hashMap.getOrDefault(category, 1) + 1
        }
        hashMap.forEach {
            answer *= it.value
        }
        println(answer-1)
    }
}