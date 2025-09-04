package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12937?language=kotlin

fun solution(num: Int): String {
    return if (num % 2 == 0) "Even" else "Odd"
}

fun main() {
    println(solution(4))
}