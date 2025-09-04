package programmers.level_1


// https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=kotlin

fun solution12933(n: Long): Long {
    return n.toString().map { it.digitToInt() }.sortedDescending().joinToString("").toLong()
}

fun main() {
    println(solution12933(118372))
}