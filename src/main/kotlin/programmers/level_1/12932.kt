package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=kotlin

fun solution(n: Long): IntArray {
    return n.toString().reversed().map {
        it.digitToInt()
    }.toIntArray()
}


fun main() {
    println(solution(12345))
}