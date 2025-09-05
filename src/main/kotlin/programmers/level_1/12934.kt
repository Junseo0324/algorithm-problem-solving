package programmers.level_1

import kotlin.math.sqrt


// https://school.programmers.co.kr/learn/courses/30/lessons/12934?language=kotlin

fun solution12934(n: Long): Long {
    for (i in 1..n) {
        if (i * i == n) return (i+1) *(i+1)
    }
    return -1
}


fun main() {
    println(solution12934(50000000000000))
}
