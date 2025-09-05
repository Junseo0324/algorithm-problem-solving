package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=kotlin

fun solution86051(numbers: IntArray): Int {
    return (0..9).filterNot {
        it in numbers
    }.sum()
}

fun main() {
    println(solution86051(intArrayOf(1,2,3,4,6,7,8,0)))
}