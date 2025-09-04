package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=kotlin

fun solution87389(n: Int): Int {
    for (i in 1..n) {
        if (n % i ==1) {
            return i
        }
    }
    return 0
}

fun main() {
    println(solution87389(12))
}