package programmers.practice04

fun main() {
    println(solution135808(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
    println(solution135808(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}

fun solution135808(k: Int, m: Int, score: IntArray): Int {
    var answer = 0
    val list = score.sortedDescending().chunked(m)

    for (box in list) {
        val p = box.minOrNull()!!
        if (box.size == m) {
            answer += p * m
        }
    }
    return answer
}