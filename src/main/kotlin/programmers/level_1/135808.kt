package programmers.level_1

// https://school.programmers.co.kr/learn/courses/30/lessons/135808?language=kotlin

/**
 * 1~k
 * 1 box = m 개
 * p = 가장 낮은 점수. -> 사과 1 box price = p * m
 * 최대 이익 계산.
 */
fun solution135808(k: Int, m: Int, score: IntArray): Int {
    var answer = 0
    score.sortedDescending().chunked(m).filter { it.size == m }.forEach { it ->
        answer += it.minOf { it } * m
    }
    return answer
}

fun main() {
    println(solution135808(4,3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}