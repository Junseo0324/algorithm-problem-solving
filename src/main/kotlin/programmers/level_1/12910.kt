package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=kotlin

fun solution12910(arr: IntArray, divisor: Int): IntArray {
    val answer = arr.filter { it % divisor == 0 }.sorted().toIntArray()
    return if (answer.isEmpty()) return intArrayOf(-1) else answer
}

fun main() {
    println(solution12910(intArrayOf(5,9,7,10),5))
}