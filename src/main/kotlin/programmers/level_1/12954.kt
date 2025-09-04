package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/12954?language=kotlin

fun solution(x: Int, n: Int): LongArray {
    var answer = longArrayOf()
    repeat(n) {
        answer += x.toLong() * (it + 1)
    }
    return answer

//    return (1..n).map { it.toLong() * x }
}

fun main() {
    println(solution(-4, 2))
}